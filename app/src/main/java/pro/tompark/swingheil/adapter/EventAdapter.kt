package pro.tompark.swingheil.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pro.tompark.swingheil.model.Event

/**
 * Created by TomPark on 2018. 5. 30.
 *
 * @author tom.hyunung.park@gmail.com
 * github : http://github.com/tomparkpro
 *
 */
class EventAdapter(private val context: Context, private val events: ArrayList<Event>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindEvent(context, events[position])
    }


    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val title = itemView?.findViewById<TextView>(android.R.id.text1)

        fun bindEvent(context: Context, event: Event) {
            title?.text = event.title
        }
    }

}