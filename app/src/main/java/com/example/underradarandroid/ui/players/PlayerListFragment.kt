package com.example.underradarandroid.ui.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.databinding.FragmentPlayerListBinding

class PlayerListFragment : Fragment() {
    private var _binding: FragmentPlayerListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PlayerListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // getting the employeelist
        val userList = DatabaseManager.users
        // Assign employeelist to ItemAdapter
        val itemAdapter = PlayerAdapter(userList)
        // Set the LayoutManager that
        // this RecyclerView will use.
        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.adapter = itemAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_list, container, false)
    }
}

