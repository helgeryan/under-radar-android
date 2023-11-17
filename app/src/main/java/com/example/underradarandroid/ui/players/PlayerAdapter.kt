package com.example.underradarandroid.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.DataClasses.UserHelper
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getCollegeForId
import com.example.underradarandroid.ui.clubs.ClubAdapter

class PlayerAdapter(private val playerList: Array<User>) : RecyclerView.Adapter<com.example.underradarandroid.ui.players.PlayerAdapter.MyViewHolder>() {
    var onClickListener: PlayerAdapter.OnClickListener? = null

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.player_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return playerList.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val player = playerList[position]
        holder.name.text = player.firstName + " " + player.lastName


        if (player.collegeCommit == null) {
            holder.commitImageView.visibility = View.GONE
        } else {
            holder.commitImageView.visibility = View.VISIBLE
        }
        if (player.videos == null) {
            holder.videoImageView.visibility = View.GONE
        } else {
            holder.videoImageView.visibility = View.VISIBLE
        }
        if (player.scoutInfo == null) {
            holder.verifiedImageView.visibility = View.GONE
        } else {
            holder.verifiedImageView.visibility = View.VISIBLE
        }
        if (UserHelper(player).isPlayer()) {
            if (player.hometown == null) {
                holder.hometown.visibility = View.GONE
            } else {
                holder.hometown.text = UserHelper(player).getHometownText()
                holder.hometown.visibility = View.VISIBLE
            }

            holder.gradYear.text = "${player.year}"
        } else {
            holder.gradYear.visibility = View.GONE
            if (player.college == null) {
                holder.hometown.visibility = View.GONE
            } else {
                val college = DatabaseManager.getCollegeForId(player.college!!)
                holder.hometown.text = college?.name
                holder.hometown.visibility = View.VISIBLE
            }
        }

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, player)
            }
        }
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: User)
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameText)
        val hometown: TextView = itemView.findViewById(R.id.hometownText)
        val gradYear: TextView = itemView.findViewById(R.id.gradText)
        val commitImageView: ImageView = itemView.findViewById((R.id.commitImage))
        val verifiedImageView: ImageView = itemView.findViewById((R.id.verifiedImage))
        val videoImageView: ImageView = itemView.findViewById((R.id.videosImages))
    }
}
