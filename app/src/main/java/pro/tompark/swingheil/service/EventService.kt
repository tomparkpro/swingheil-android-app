package pro.tompark.swingheil.service

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import pro.tompark.swingheil.model.Event
import pro.tompark.swingheil.utility.URL_GET_EVENTS

object EventService {

    val tag = EventService::class.simpleName
    val events = ArrayList<Event>()

    /**
    [
    {
    "createdDt": "2018-05-23T16:08:46.000+0000",
    "updatedDt": "2018-05-23T16:08:46.000+0000",
    "eventSn": 14,
    "title": "&#12613;&#12599;&#12596;&#12613;",
    "bodyText": null,
    "startDt": "2018-05-07T15:00:00.000+0000",
    "endDt": "2018-05-24T15:00:00.000+0000",
    "eventType": "Social"
    }
    ]
     */
    fun getEvents(context: Context, complete: (Boolean) -> Unit) {

        val findEventsRequest = object : JsonArrayRequest(Method.GET, URL_GET_EVENTS, null, Response.Listener { response ->
            clearEvent()

            try {
                for (x in 0 until response.length()) {
                    val event = response.getJSONObject(x)
                    val eventsn = event.getLong("eventSn")
                    val title = event.getString("title")
                    val bodyText = event.getString("bodyText")
                    val eventType = event.getString("eventType")
                    val startDt = event.getString("startDt")
                    val endDt = event.getString("endDt")
                    val createdDt = event.getString("createdDt")
                    val updatedDt = event.getString("updatedDt")

                    val newEvent = Event(eventsn, title, bodyText, eventType, startDt, endDt, createdDt, updatedDt)
                    this.events.add(newEvent)
                }
                complete(true)
            } catch (e: JSONException) {
                Log.d(tag, "EXC ${e.localizedMessage}")
            }
        }, Response.ErrorListener { error ->
            Log.d(tag, "Could not find event: $error")
            complete(false)
        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
        }

        Volley.newRequestQueue(context).add(findEventsRequest)
    }

    fun clearEvent() {
        events.clear()
    }
}