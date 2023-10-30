package com.example.underradarandroid.ui.events

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getUserForId
import com.example.underradarandroid.Resources.Extensions.UnderRadarDateFormatter
import com.example.underradarandroid.Resources.UnderRadarFragment
import com.example.underradarandroid.databinding.FragmentCollegeBinding
import com.example.underradarandroid.databinding.FragmentEventBinding

class EventFragment : UnderRadarFragment() {

    private lateinit var binding: FragmentEventBinding
    private lateinit var event: Event
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(layoutInflater)
        val root = binding.root
        val eventArg = arguments?.getSerializable("event", Event::class.java)
        eventArg?.let {
            this.event = eventArg

            binding.titleTextView.text = event?.title
            binding.desciptionTextView.text = event?.text
            bindDate()
            bindHeaderImage()
            bindAuthor()
            bindAdditionalLink()
            bindShareButton()
        }

        return root
    }

    private fun bindAdditionalLink() {
        event.additionalLink?.let {
            binding.additonalInfoButton.setOnClickListener {
                openLink(Uri.parse(event.additionalLink))
            }
        }
    }

    private fun bindAuthor() {
        if (event?.authorId == null) {
            binding.authorTextView.visibility = View.GONE
        } else {
            binding.authorTextView.visibility = View.VISIBLE
            event?.authorId?.let {
                Log.d("UR Logging", DatabaseManager.getUserForId(event.authorId)?.getName() ?: "missing name")
                binding.authorTextView.text = DatabaseManager.getUserForId(event.authorId)?.getName()
            }
        }
    }

    private fun bindHeaderImage() {
        if (event?.headerImage == null) {
            binding.eventImageView.visibility = View.GONE
        } else {
            binding.eventImageView.visibility = View.VISIBLE
        }
    }

    private fun bindDate() {
        event?.startDate?.let {
            val startDate = UnderRadarDateFormatter().getDisplayDate(event.startDate, "MM/dd")
            event?.endDate.let {
                val endDate = UnderRadarDateFormatter().getDisplayDate(event.startDate, "MM/dd")
                binding.dateTextView.text = "$startDate - $endDate"
            }
        }
    }

    private fun bindShareButton() {
        binding.shareEventButton.setOnClickListener {
            val id = event.id
            shareLink("under-radar://open-event?id=$id")
        }
    }
}