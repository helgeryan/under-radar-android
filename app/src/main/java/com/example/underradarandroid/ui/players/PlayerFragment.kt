package com.example.underradarandroid.ui.players

import android.content.Context
import android.media.MediaController2
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.DataClasses.UserHelper
import com.example.underradarandroid.DataClasses.Video
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentCollegeBinding
import com.example.underradarandroid.databinding.FragmentPlayerBinding
import com.squareup.picasso.Picasso

class PlayerFragment : Fragment() {
    private lateinit var binding: FragmentPlayerBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentPlayerBinding.inflate(layoutInflater)
        val root = binding.root
        val user = arguments?.getSerializable("player", User::class.java)

        user?.let {
            user.year?.let {
                binding.yearText.text = "Class of ${user.year}"
            }

            binding.firstNameText.text = user.firstName
            binding.lastNameText.text = user.lastName
            binding.hometownText.text = UserHelper(user).getHometownText()
            binding.highSchoolText.text = user.school

            user.profilePicUrl?.let {
                Picasso
                    .get()
                    .load(user.profilePicUrl)
                    .placeholder(R.drawable.ic_club)
                    .into(binding.profileImageView)
            }

            val videos = user.videos
            videos?.let {
                val videoAdapter = PlayerVideoAdapter(videos.toTypedArray(), context)
                val recyclerView = binding.videoRecyclerView
                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = videoAdapter
            }
        }

        return root
    }
}


class PlayerVideoAdapter(private val videoList: Array<Video>, private val context: Context?) : RecyclerView.Adapter<com.example.underradarandroid.ui.players.PlayerVideoAdapter.MyViewHolder>() {
    var onClickListener: PlayerVideoAdapter.OnClickListener? = null

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.video_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return 10
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val video = videoList.first()
//        val uri: Uri = Uri.parse(video.videoUrl)
//        holder.videoView.setVideoURI(uri)
//
//        // creating object of
//        // media controller class
//        val mediaController = MediaController(context)
//
//        // sets the anchor view
//        // anchor view for the videoView
//        mediaController.setAnchorView(holder.videoView);
//
//        // sets the media player to the videoView
//        mediaController.setMediaPlayer(holder.videoView);
//
//        // sets the media controller to the videoView
//        holder.videoView.setMediaController(mediaController);
//
//        // starts the video
//        holder.videoView.start();
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: Video)
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoView: VideoView = itemView.findViewById(R.id.videoView)
    }
}
