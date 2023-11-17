package com.example.underradarandroid.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.UserNotification
import com.example.underradarandroid.NavGraphDirections
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.AuthManager.AuthManager
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getNotifications
import com.example.underradarandroid.Resources.DatabaseManager.hasCoaches
import com.example.underradarandroid.Resources.DatabaseManager.hasCommits
import com.example.underradarandroid.Resources.DatabaseManager.markNotificationsAsRead
import com.example.underradarandroid.databinding.FragmentCollegeListBinding
import com.example.underradarandroid.databinding.FragmentNotificationsBinding
import com.example.underradarandroid.ui.colleges.CollegeListViewModel
import com.example.underradarandroid.ui.colleges.CollegesAdapter

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DatabaseManager.readNotifications.observe(viewLifecycleOwner, Observer { notifications ->

            val itemAdapter = NotificationsAdapter(notifications)
            itemAdapter.onClickListener = object: NotificationsAdapter.OnClickListener {
                override fun onClick(position: Int, model: UserNotification) {
//                    val action = NavGraphDirections.actionGlobalCollegeFragment(model)
//                    findNavController().navigate(action)
                    Log.d("UR Logging", "${model.text}")
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
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val notifications = DatabaseManager.readNotifications.value
        notifications?.let {
            DatabaseManager.markNotificationsAsRead(notifications) {
                if (AuthManager.readUser.value != null) {
                    DatabaseManager.getNotifications(AuthManager.readUser.value!!.id)
                }
            }
        }
    }
}