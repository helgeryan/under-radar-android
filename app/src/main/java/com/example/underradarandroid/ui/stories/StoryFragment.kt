package com.example.underradarandroid.ui.stories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.underradarandroid.DataClasses.Story
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getUserForId
import com.example.underradarandroid.databinding.FragmentStoryBinding

class StoryFragment : Fragment() {

    private lateinit var binding: FragmentStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
        binding.dateTextView.text = story?.date
        if (story?.authorId == null) {
            binding.authorTextView.visibility = View.GONE
        } else {
            binding.authorTextView.visibility = View.VISIBLE
            story?.authorId?.let {
                Log.d("UR Logging", DatabaseManager.getUserForId(story.authorId)?.getName() ?: "missing name")

                binding.authorTextView.text = DatabaseManager.getUserForId(story.authorId)?.getName()
            }
        }
        binding.desciptionTextView.text = story?.description

        return root
    }
}