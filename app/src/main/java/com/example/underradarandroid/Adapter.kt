package com.example.underradarandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.College


class Adapter(private val collegeList: Array<College>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
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
        val currentEmp = collegeList[position]
        holder.name.text = currentEmp.getCollegeName()
        holder.email.text = currentEmp.getLocation()
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val email: TextView = itemView.findViewById(R.id.tvLocation)
    }
}