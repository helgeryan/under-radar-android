package com.example.underradarandroid.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Story
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.ui.stories.StoriesAdapter

class HomeStoriesListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DatabaseManager.readStories.observe(viewLifecycleOwner, Observer { storiesList ->
            val animationView: com.airbnb.lottie.LottieAnimationView = view.findViewById(com.example.underradarandroid.R.id.animation_view)
            val recyclerView: androidx.recyclerview.widget.RecyclerView = view.findViewById(com.example.underradarandroid.R.id.recycleView)

            if (storiesList.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
                animationView.visibility = View.INVISIBLE
                val itemAdapter = StoriesAdapter(storiesList)
                itemAdapter.onClickListener = object: StoriesAdapter.OnClickListener {
                    override fun onClick(position: Int, model: Story) {
                        val bundle = Bundle()
                        bundle.putSerializable("story", model)
                        findNavController().navigate(R.id.action_navigation_home_to_storyFragment, bundle)
                        Log.d("UR Logging", "${model.title}")
                    }
                }
                // Set the LayoutManager that
                // this RecyclerView will use.
                val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager = layoutManager
                // adapter instance is set to the
                // recyclerview to inflate the items.
                recyclerView.adapter = itemAdapter

                val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
                recyclerView.addItemDecoration(dividerItemDecoration)
            } else {
                recyclerView.visibility = View.INVISIBLE
                animationView.visibility = View.VISIBLE
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story_list, container, false)
    }
}