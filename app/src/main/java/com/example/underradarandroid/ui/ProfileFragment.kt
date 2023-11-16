package com.example.underradarandroid.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.DataClasses.UserHelper
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.AuthManager.AuthManager
import com.example.underradarandroid.Resources.UnderRadarFragment
import com.example.underradarandroid.databinding.FragmentPlayerBinding
import com.example.underradarandroid.databinding.FragmentProfileBinding
import com.example.underradarandroid.ui.players.PlayerVideoAdapter
import com.squareup.picasso.Picasso


class ProfileFragment : UnderRadarFragment() {
    private lateinit var binding: FragmentProfileBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(layoutInflater)
        val root = binding.root
        val user = AuthManager.readUser.value

        binding.shareButton.setOnClickListener {
            val userId = user!!.id
            shareLink("under-radar://open-user?id=$userId")
        }

        user?.let {
            user.year?.let {
                binding.yearText.text = "Class of ${user.year}"
            }

            binding.firstNameText.text = user.firstName
            binding.lastNameText.text = user.lastName
            if (UserHelper(user).isPlayer()) {
                binding.hometownText.text = UserHelper(user).getHometownText()
                binding.highSchoolText.text = user.school
            } else {
                binding.hometownText.visibility = View.GONE
                binding.highSchoolText.visibility = View.GONE
            }

            if (user.email == null && user.phone == null) {
                binding.contactHeaderTextView.visibility = View.GONE
                binding.emailTextView.visibility = View.GONE
                binding.phoneTextView.visibility = View.GONE
            } else {
                binding.emailTextView.text = user.email
                binding.phoneTextView.text = user.phone
            }

            user.profilePicUrl?.let {
                Picasso
                    .get()
                    .load(user.profilePicUrl)
                    .placeholder(R.drawable.ic_default_profile)
                    .into(binding.profileImageView)
            }
        }


//        val videos = user?.videos
//        videos?.let {
//            val videoAdapter = PlayerVideoAdapter(videos.toTypedArray(), context)
//            val recyclerView = binding.videoRecyclerView
//            val layoutManager = LinearLayoutManager(context)
//            recyclerView.layoutManager = layoutManager
//            recyclerView.adapter = videoAdapter
//        }

        return root
    }
}