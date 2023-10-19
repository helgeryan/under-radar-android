package com.example.underradarandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getConferenceForId


class CollegesAdapter(private val collegeList: Array<College>) : RecyclerView.Adapter<CollegesAdapter.MyViewHolder>() {

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.college_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return collegeList.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val college = collegeList[position]
        holder.name.text = college.getCollegeName()
        holder.email.text = college.getLocation()
        val conferenceId = college.conferenceId
        conferenceId?.let {
            val conference = DatabaseManager.getConferenceForId(conferenceId)
            conference?.let {
                holder.division.text = conference.division
            }
        }
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameText)
        val email: TextView = itemView.findViewById(R.id.locationText)
        val division: TextView = itemView.findViewById(R.id.divisionText)
    }
}