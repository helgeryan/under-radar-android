package com.example.underradarandroid.ui.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.NavGraphDirections
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.hasCoaches
import com.example.underradarandroid.Resources.DatabaseManager.hasCommits
import com.example.underradarandroid.databinding.FragmentPlayerListBinding
import com.example.underradarandroid.ui.clubs.ClubAdapter

class PlayerListFragment(private var users: Array<User>? = null, private val emptyText: String = "No players at this time") : Fragment() {
    private var _binding: FragmentPlayerListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: PlayerListViewModel
    private val sort: (User) -> Boolean = { user: User ->  user.videos != null || user.scoutInfo != null || user.collegeCommit != null }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (users != null) {
            Log.d("UR Comparison", users.toString())
            val itemAdapter = PlayerAdapter(users!!)

            val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)

            val emptyTextView: TextView = view.findViewById(R.id.emptyPageTextView)
            if (users!!.isEmpty()) {
                recyclerView.visibility = View.GONE
                emptyTextView.text = emptyText
                emptyTextView.visibility = View.VISIBLE
            }
            itemAdapter.onClickListener = object: PlayerAdapter.OnClickListener {
                override fun onClick(position: Int, model: User) {
                    val action = NavGraphDirections.actionGlobalPlayerFragment(model)
                    findNavController().navigate(action)
                    Log.d("UR Logging", "${model.firstName}")
                }
            }
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = itemAdapter

            val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
            recyclerView.addItemDecoration(dividerItemDecoration)
        } else {
            DatabaseManager.readUsers.observe(viewLifecycleOwner, Observer { userList ->

                val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)

                val emptyTextView: TextView = view.findViewById(R.id.emptyPageTextView)
                if (userList.isEmpty()) {
                    recyclerView.visibility = View.GONE
                    emptyTextView.text = emptyText
                    emptyTextView.visibility = View.VISIBLE
                }
                val playerList = userList.filter { it.isPlayer() }
                val itemAdapter = PlayerAdapter(playerList.sortedByDescending(sort).toTypedArray())

                itemAdapter.onClickListener = object: PlayerAdapter.OnClickListener {
                    override fun onClick(position: Int, model: User) {
                        val action = NavGraphDirections.actionGlobalPlayerFragment(model)
                        findNavController().navigate(action)
                        Log.d("UR Logging", "${model.firstName}")
                    }
                }

                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = itemAdapter

                val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
                recyclerView.addItemDecoration(dividerItemDecoration)
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_list, container, false)
    }
}

