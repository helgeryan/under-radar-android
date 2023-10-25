package com.example.underradarandroid.ui.stories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.DataClasses.Story
import com.example.underradarandroid.R
import com.example.underradarandroid.ui.events.EventsAdapter

class StoriesAdapter(private val storiesList: Array<Story>) : RecyclerView.Adapter<StoriesAdapter.MyViewHolder>() {
    var onClickListener: StoriesAdapter.OnClickListener? = null
    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.story_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return storiesList.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = storiesList[position]
        holder.name.text = story.title
        holder.description.text = story.description
        holder.date.text = story.date
        holder.state.text = story.state

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, story)
            }
        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Story)
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val description: TextView = itemView.findViewById(R.id.descriptionTextView)
        val date: TextView = itemView.findViewById(R.id.dateTextView)
        val state: TextView = itemView.findViewById(R.id.stateText)
    }
}
