package pro.tompark.swingheil.model

/**
 * Created by TomPark on 2018. 5. 29.
 *
 * @author tom.hyunung.park@gmail.com
 * github : http://github.com/tomparkpro
 *
 */
//    "createdDt": "2018-05-21T15:42:05.000+0000",
//    "updatedDt": "2018-05-23T11:35:13.000+0000",
//    "eventSn": 1,
//    "title": "Event Title1",
//    "bodyText": null,
//    "startDt": null,
//    "endDt": null,
//    "eventType": "Notice"
class Event constructor(val eventsn: Long, val title: String, val bodyText: String,
                        val eventType: String, val startDt: String, val endDt: String,
                        val createdDt: String, val updatedDt: String)