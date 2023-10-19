package com.example.underradarandroid.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.underradarandroid.R

class HomePageAdapter( fm: Fragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeStoriesListFragment()
            1 -> HomeEventsListFragment()
            else -> HomeStoriesListFragment()
        }
    }

}