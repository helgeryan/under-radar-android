package com.example.underradarandroid.ui.colleges

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentCollegeListBinding
import com.example.underradarandroid.databinding.FragmentDashboardBinding
import com.example.underradarandroid.ui.dashboard.DashboardViewModel

class CollegeListFragment : Fragment() {

    private var _binding: FragmentCollegeListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: CollegeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val collegeListViewModel =
            ViewModelProvider(this).get(CollegeListViewModel::class.java)

        _binding = FragmentCollegeListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textColleges
        collegeListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollegeListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}