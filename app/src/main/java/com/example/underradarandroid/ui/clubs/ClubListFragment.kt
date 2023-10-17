package com.example.underradarandroid.ui.clubs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentClubListBinding
import com.example.underradarandroid.databinding.FragmentCollegeListBinding
import com.example.underradarandroid.ui.colleges.CollegeListViewModel

class ClubListFragment : Fragment() {

    private var _binding: FragmentClubListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: ClubListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val clubListViewModel =
            ViewModelProvider(this).get(ClubListViewModel::class.java)

        _binding = FragmentClubListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textClubs
        clubListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClubListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}