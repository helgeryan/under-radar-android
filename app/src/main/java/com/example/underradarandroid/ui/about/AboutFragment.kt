package com.example.underradarandroid.ui.about

import android.app.ActionBar.LayoutParams
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.ImageHelper
import com.example.underradarandroid.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    val legendItems: Array<LegendItem> = arrayOf(
        LegendItem("Valid", ImageHelper.valid, R.color.valid),
        LegendItem("Invalid", ImageHelper.invalid, R.color.invalid),
        LegendItem("Bookmark/Save", ImageHelper.verified),
        LegendItem("View", ImageHelper.view),
        LegendItem("Share", ImageHelper.share),
        LegendItem("Tag", ImageHelper.tag),
        LegendItem("Notification", ImageHelper.notification),
        LegendItem("Coach", ImageHelper.coach),
        LegendItem("Club", ImageHelper.club),
        LegendItem("Filter", ImageHelper.filter),
        LegendItem("Sort", ImageHelper.sort),
        LegendItem("College", ImageHelper.college),
        LegendItem("Player", ImageHelper.player),
        LegendItem("Verified",ImageHelper.verified),
        LegendItem("Commit", ImageHelper.commit, R.color.commit),
        LegendItem("Video", ImageHelper.video, R.color.video),
        LegendItem("Note", ImageHelper.note),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(layoutInflater)
        val linearLayout: LinearLayout = binding.aboutLinearLayout

        val layoutManager = LinearLayoutManager(context)
        binding.recycleView.layoutManager = layoutManager
        binding.recycleView.adapter = LegendAdapter(legendItems)

        val bottomView = View(context)
        val params = LayoutParams(50, 100)
        bottomView.layoutParams = params
        linearLayout.addView(bottomView)
        return binding.root
    }
}