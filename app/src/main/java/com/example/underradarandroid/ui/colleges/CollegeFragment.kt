package com.example.underradarandroid.ui.colleges

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentCollegeBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

class CollegeFragment : Fragment() {

    private lateinit var binding: FragmentCollegeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val activity = activity
        val actionBar = activity?.actionBar
        actionBar?.title = "Hello"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollegeBinding.inflate(layoutInflater)
        val root = binding.root
        val college = arguments?.getSerializable("college", College::class.java)
        binding.nameText.text = college?.name
        binding.locationText.text = college?.getLocation()

        val logo = college?.logo
        logo?.let {
            Picasso
                .get()
                .load(logo)
                .placeholder(R.drawable.ic_club)
                .into(binding.logoImageView)
        }
        val viewPager = binding.collegePlayerPager
        // Inflate the layout for this fragment



        college?.let {
            val adapter = CollegePageAdapter(this, college)

            viewPager.adapter = adapter
            TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Players"
                    }
                    1 -> {
                        tab.text = "Coaches"
                    }
                    2 -> {
                        tab.text = "Commits"
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