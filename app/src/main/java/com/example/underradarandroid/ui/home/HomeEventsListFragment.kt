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
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.NavGraphDirections
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.ui.events.EventsAdapter

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
                itemAdapter.onClickListener = object: EventsAdapter.OnClickListener {
                    override fun onClick(position: Int, model: Event) {
                        val action = NavGraphDirections.actionGlobalEventFragment(model)
                        findNavController().navigate(action)
                        Log.d("UR Logging", "${model.title}")
                    }
                }
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
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }
}