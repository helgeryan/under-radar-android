package com.example.underradarandroid.ui.colleges

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
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getCoachesForCollege
import com.example.underradarandroid.Resources.DatabaseManager.hasCoaches
import com.example.underradarandroid.Resources.DatabaseManager.hasCommits
import com.example.underradarandroid.databinding.FragmentCollegeListBinding

class CollegeListFragment : Fragment() {

    private var _binding: FragmentCollegeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: CollegeListViewModel

    private val sort: (College) -> Boolean = {college: College -> DatabaseManager.hasCoaches(college.id) || DatabaseManager.hasCommits(college.id) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DatabaseManager.readCollege.observe(viewLifecycleOwner, Observer { collegeList ->
            val sorted = collegeList.sortedByDescending(sort)
            val itemAdapter = CollegesAdapter(sorted.toTypedArray())
            itemAdapter.onClickListener = object: CollegesAdapter.OnClickListener {
                override fun onClick(position: Int, model: College) {
                    val bundle = Bundle()
                    bundle.putSerializable("college", model)
                    findNavController().navigate(R.id.collegeFragment, bundle)
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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_college_list, container, false)
    }

}