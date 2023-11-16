package com.example.underradarandroid.ui.colleges

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getCoachesForCollege
import com.example.underradarandroid.Resources.DatabaseManager.getCommitmentsForCollege
import com.example.underradarandroid.Resources.DatabaseManager.getPlayersForCollege
import com.example.underradarandroid.ui.players.PlayerListFragment

class CollegePageAdapter( fm: Fragment, val college: College): FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                val collegePlayers = DatabaseManager.getPlayersForCollege(college.id)
                return PlayerListFragment(collegePlayers, "No players at this time")
            }
            1 -> {
                val collegeCoaches = DatabaseManager.getCoachesForCollege(college.id)
                return PlayerListFragment(collegeCoaches, "No coaches at this time")
            }
            2 -> {
                val collegeCommitments = DatabaseManager.getCommitmentsForCollege(college.id)
                return PlayerListFragment(collegeCommitments, "No commitments at this time")
            }
            else -> {
                val collegeCoaches = DatabaseManager.getCoachesForCollege(college.id)
                return PlayerListFragment(collegeCoaches, "No coaches at this time")
            }
        }
    }

}