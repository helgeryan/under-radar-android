package com.example.underradarandroid.ui.notifications

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.UserNotification
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.Extensions.UnderRadarDateFormatter

class NotificationsAdapter(private val notifications: Array<UserNotification>) : RecyclerView.Adapter<NotificationsAdapter.MyViewHolder>() {
    var onClickListener: OnClickListener? = null

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return notifications.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val notification = notifications[position]
        holder.notificationText.text = notification.text
        holder.dateText.text = UnderRadarDateFormatter().daysAwayString(notification.date)
        holder.iconImageView.setColorFilter(R.color.utrBlue)
        holder.iconImageView.setImageResource(notification.getIcon())
        if (!notification.isRead) {
            holder.itemView.setBackgroundResource(R.color.unreadNotificationColor)
        }


    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: UserNotification)
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notificationText: TextView = itemView.findViewById(R.id.notificationTextView)
        val dateText: TextView = itemView.findViewById(R.id.dateTextView)
        val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)
    }
}
