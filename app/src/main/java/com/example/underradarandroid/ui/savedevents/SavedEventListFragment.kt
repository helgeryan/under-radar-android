package com.example.underradarandroid.ui.savedevents

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
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.DataClasses.UserNotification
import com.example.underradarandroid.NavGraphDirections
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.databinding.FragmentNotificationsBinding
import com.example.underradarandroid.databinding.FragmentSavedEventListBinding
import com.example.underradarandroid.ui.notifications.NotificationsAdapter

class SavedEventListFragment : Fragment() {

    private var _binding: FragmentSavedEventListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DatabaseManager.readSavedEvents.observe(viewLifecycleOwner, Observer { savedEvents ->

            val itemAdapter = SavedEventAdapter(savedEvents)
            itemAdapter.onClickListener = object: SavedEventAdapter.OnClickListener {
                override fun onClick(position: Int, model: Event) {
                    val action = NavGraphDirections.actionGlobalEventFragment(model)
                    findNavController().navigate(action)
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
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saved_event_list, container, false)
    }

}