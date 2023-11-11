package com.example.underradarandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.underradarandroid.R

class HomeFragment1 : Fragment(R.layout.fragment_home1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button_login: Button = view.findViewById(R.id.button_login)
        button_login.setOnClickListener {
            val action = HomeFragment1Directions.actionHomeFragment1ToLoginFragment()
            findNavController().navigate(action)
        }
    }
}