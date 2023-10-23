package com.example.underradarandroid.ui.clubs

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.R

class ClubFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val club = arguments?.getSerializable("club", Club::class.java)
        Log.d("UR Logging", club.toString())
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club, container, false)
    }
}