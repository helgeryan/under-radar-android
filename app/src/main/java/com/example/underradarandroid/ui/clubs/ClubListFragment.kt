package com.example.underradarandroid.ui.clubs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.underradarandroid.R

class ClubListFragment : Fragment() {

    companion object {
        fun newInstance() = ClubListFragment()
    }

    private lateinit var viewModel: ClubListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_club_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClubListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}