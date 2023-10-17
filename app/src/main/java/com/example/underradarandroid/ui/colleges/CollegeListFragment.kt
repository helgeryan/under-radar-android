package com.example.underradarandroid.ui.colleges

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.underradarandroid.R

class CollegeListFragment : Fragment() {

    companion object {
        fun newInstance() = CollegeListFragment()
    }

    private lateinit var viewModel: CollegeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_college_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollegeListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}