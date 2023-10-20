package com.example.underradarandroid.ui.clubs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.R
import com.example.underradarandroid.ui.colleges.CollegesAdapter


class ClubAdapter(private val clubList: Array<Club>) : RecyclerView.Adapter<ClubAdapter.MyViewHolder>() {
    var onClickListener: ClubAdapter.OnClickListener? = null

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.club_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return clubList.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val club = clubList[position]
        holder.name.text = club.name
        holder.email.text = club.getLocation()

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, club)
            }
        }
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: Club)
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameText)
        val email: TextView = itemView.findViewById(R.id.locationText)
    }
}