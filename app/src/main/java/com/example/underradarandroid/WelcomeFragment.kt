package com.example.underradarandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val args: WelcomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val button_ok: Button = view.findViewById(R.id.button_ok)
        val text_view_username: TextView = view.findViewById(R.id.text_view_username)
        val text_view_password: TextView = view.findViewById(R.id.text_view_password)
        text_view_username.text = args.username
        text_view_password.text = args.password

        button_ok.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment1()
            findNavController().navigate(action)
        }
    }
}