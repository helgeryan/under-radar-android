package com.example.underradarandroid.ui.about

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Story
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.Extensions.UnderRadarDateFormatter


class LegendAdapter(private val legendItems: Array<LegendItem>) : RecyclerView.Adapter<LegendAdapter.MyViewHolder>() {

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_legend_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return legendItems.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = legendItems[position]
        holder.icon.setImageResource(item.icon)
        holder.itemTextView.text = item.name
        val color = ContextCompat.getColor(holder.icon.context, item.color)
        holder.icon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iconImageView)
        val itemTextView: TextView = itemView.findViewById(R.id.itemTextView)
    }
}
