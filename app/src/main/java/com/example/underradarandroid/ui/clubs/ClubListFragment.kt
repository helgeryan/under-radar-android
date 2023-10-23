package com.example.underradarandroid.ui.clubs

import androidx.lifecycle.ViewModelProvider
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
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.databinding.FragmentClubListBinding
import com.example.underradarandroid.databinding.FragmentCollegeListBinding
import com.example.underradarandroid.ui.colleges.CollegeListViewModel
import com.example.underradarandroid.ui.colleges.CollegesAdapter

class ClubListFragment : Fragment() {

    private var _binding: FragmentClubListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: ClubListViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DatabaseManager.readClubs.observe(viewLifecycleOwner, Observer { clubList ->

            val itemAdapter = ClubAdapter(clubList)
            itemAdapter.onClickListener = object: ClubAdapter.OnClickListener {
                override fun onClick(position: Int, model: Club) {
                    val bundle = Bundle()
                    bundle.putSerializable("club", model)
                    findNavController().navigate(R.id.action_navigation_clubs_to_clubFragment, bundle)
                    Log.d("UR Logging", "${model.name}")
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_club_list, container, false)
    }
}