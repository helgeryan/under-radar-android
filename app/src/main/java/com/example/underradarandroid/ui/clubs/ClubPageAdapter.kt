package com.example.underradarandroid.ui.clubs

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.Resources.DatabaseManager.getCoachesForClub
import com.example.underradarandroid.Resources.DatabaseManager.getCommitmentsForClub
import com.example.underradarandroid.Resources.DatabaseManager.getPlayersForClub
import com.example.underradarandroid.ui.players.PlayerListFragment

class ClubPageAdapter( fm: Fragment, val club: Club) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                val clubPlayers = DatabaseManager.getPlayersForClub(club.id)
                return PlayerListFragment(clubPlayers, "No players at this time")
            }
            1 -> {
                val clubCoaches = DatabaseManager.getCoachesForClub(club.id)
                return PlayerListFragment(clubCoaches, "No coaches at this time")
            }
            2 -> {
                val clubCommitments = DatabaseManager.getCommitmentsForClub(club.id)
                return PlayerListFragment(clubCommitments, "No commitments at this time")
            }
            else -> {
                val clubCoaches = DatabaseManager.getCoachesForClub(club.id)
                return PlayerListFragment(clubCoaches, "No coaches at this time")
            }
        }
    }

}