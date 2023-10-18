package com.example.underradarandroid.ui.home
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.underradarandroid.R

class PageAdapter( fm: Fragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> Fragment1(R.drawable.carousel1)
            1 -> Fragment1(R.drawable.carousel2)
            2 -> Fragment1(R.drawable.carousel3)
            else -> Fragment1(R.drawable.carousel1)
        }
    }

}