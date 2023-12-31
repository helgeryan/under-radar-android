package com.example.underradarandroid.ui.stories

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.underradarandroid.DataClasses.Story
import com.example.underradarandroid.DataClasses.UserHelper
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getUserForId
import com.example.underradarandroid.Resources.Extensions.UnderRadarDateFormatter
import com.example.underradarandroid.databinding.FragmentStoryBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class StoryFragment : Fragment() {

    private lateinit var binding: FragmentStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoryBinding.inflate(layoutInflater)
        val root = binding.root
        val story = arguments?.getSerializable("story", Story::class.java)

        if (story?.headerImage == null) {
            binding.storyImageView.visibility = View.GONE
        } else {
            binding.storyImageView.visibility = View.VISIBLE
        }
        binding.titleTextView.text = story?.title

        binding.dateTextView.text = UnderRadarDateFormatter().getDisplayDate(story!!.date, "MM/dd")

        if (story?.authorId == null) {
            binding.authorTextView.visibility = View.GONE
        } else {
            binding.authorTextView.visibility = View.VISIBLE
            story?.authorId?.let {
                val user = DatabaseManager.getUserForId(story.authorId)
                user?.let {
                    binding.authorTextView.text = UserHelper(user).getName()
                }
            }
        }
        binding.desciptionTextView.text = story?.description

        return root
    }
}