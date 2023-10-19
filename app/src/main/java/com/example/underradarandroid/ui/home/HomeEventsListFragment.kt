package com.example.underradarandroid.ui.home

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.ui.events.EventsAdapter
import com.example.underradarandroid.ui.stories.StoriesAdapter

class HomeEventsListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getting the employeelist
        DatabaseManager.readEvents.observe(viewLifecycleOwner, Observer { eventList ->
            val animationView: com.airbnb.lottie.LottieAnimationView = view.findViewById(com.example.underradarandroid.R.id.animation_view)
            val recyclerView: androidx.recyclerview.widget.RecyclerView = view.findViewById(com.example.underradarandroid.R.id.recycleView)

            if (eventList.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
                animationView.visibility = View.INVISIBLE
                // Assign employeelist to ItemAdapter
                val itemAdapter = com.example.underradarandroid.ui.events.EventsAdapter(eventList)
                // Set the LayoutManager that
                // this RecyclerView will use.
                recyclerView.layoutManager =
                    androidx.recyclerview.widget.LinearLayoutManager(context)
                // adapter instance is set to the
                // recyclerview to inflate the items.
                recyclerView.adapter = itemAdapter
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
        return inflater.inflate(R.layout.fragment_2, container, false)
    }
}