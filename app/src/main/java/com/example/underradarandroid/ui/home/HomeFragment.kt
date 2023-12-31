package com.example.underradarandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.underradarandroid.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewPager: ViewPager2 = binding.carousel
        val adapter = PageAdapter(this)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = binding.tabLayout

        val viewPager2: ViewPager2 = binding.carousel2

        val adapter2 = HomePageAdapter(this)
        viewPager2.adapter = adapter2
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Stories"
                }
                1 -> {
                    tab.text = "Events"
                }
                else -> {
                    tab.text = "Stories"
                }
            }
        }.attach()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}