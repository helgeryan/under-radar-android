package com.example.underradarandroid.ui.clubs

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentClubBinding
import com.example.underradarandroid.ui.home.HomePageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

class ClubFragment : Fragment() {

    private lateinit var binding: FragmentClubBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val club = arguments?.getSerializable("club", Club::class.java)
//
//        Log.d("UR Logging", club.toString())
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClubBinding.inflate(layoutInflater)
        val root = binding.root
        val club = arguments?.getSerializable("club", Club::class.java)
        binding.nameText.text = club?.name
        binding.locationText.text = club?.getLocation()

        val logo = club?.logo
        logo?.let {
            Picasso
                .get()
                .load(logo)
                .placeholder(R.drawable.ic_club)
                .into(binding.logoImageView)
        }
        val viewPager = binding.clubPlayerPager
        // Inflate the layout for this fragment



        club?.let {
            val adapter = ClubPageAdapter(this, club)
            viewPager.adapter = adapter
            TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Players"
                    }
                    1 -> {
                        tab.text = "Commits"
                    }
                    2 -> {
                        tab.text = "Coaches"
                    }
                    else -> {
                        tab.text = "Players"
                    }
                }
            }.attach()
        }
        return root
    }
}