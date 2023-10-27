package com.example.underradarandroid.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentCollegeBinding
import com.example.underradarandroid.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    private lateinit var binding: FragmentEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(layoutInflater)
        val root = binding.root
        val event = arguments?.getSerializable("event", Event::class.java)


        if (event?.headerImage == null) {
            binding.eventImageView.visibility = View.GONE
        } else {
            binding.eventImageView.visibility = View.VISIBLE
        }

        binding.titleTextView.text = event?.title
        binding.dateTextView.text = event?.startDate
        binding.authorTextView.text = event?.authorId
        binding.desciptionTextView.text = event?.description

        return root
    }
}