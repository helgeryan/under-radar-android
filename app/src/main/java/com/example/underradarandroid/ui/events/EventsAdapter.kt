package com.example.underradarandroid.ui.events

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.Extensions.UnderRadarDateFormatter
import com.example.underradarandroid.ui.colleges.CollegesAdapter


class EventsAdapter(private val eventsList: Array<Event>) : RecyclerView.Adapter<EventsAdapter.MyViewHolder>() {
    var onClickListener: EventsAdapter.OnClickListener? = null
    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.event_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return eventsList.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val event = eventsList[position]
        holder.name.text = event.title
        holder.description.text = event.description
        holder.date.text = UnderRadarDateFormatter().daysInFuture(event.startDate)
        holder.state.text = event.state

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, event)
            }
        }
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: Event)
    }
    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val description: TextView = itemView.findViewById(R.id.descriptionTextView)
        val date: TextView = itemView.findViewById(R.id.dateTextView)
        val state: TextView = itemView.findViewById(R.id.stateText)
    }
}
