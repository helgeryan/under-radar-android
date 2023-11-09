package com.example.underradarandroid

import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.underradarandroid.databinding.FragmentAboutBinding

data class LegendItem(
    val name: String,
    val icon: Int,
    val color: String = "0000DE"
)

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    val legendItems: Array<LegendItem> = arrayOf(
        LegendItem("Valid", R.drawable.ic_verified, "00DE00"),
        LegendItem("Invalid", R.drawable.ic_verified, "DE0000"),
        LegendItem("Bookmark/Save", R.drawable.ic_verified),
        LegendItem("View", R.drawable.ic_verified),
        LegendItem("Share", R.drawable.ic_verified),
        LegendItem("Tag", R.drawable.ic_verified),
        LegendItem("Notification", R.drawable.ic_verified),
        LegendItem("Coach", R.drawable.ic_verified),
        LegendItem("Club", R.drawable.ic_club),
        LegendItem("Filter", R.drawable.ic_verified),
        LegendItem("Sort", R.drawable.ic_verified),
        LegendItem("College", R.drawable.ic_college),
        LegendItem("Player", R.drawable.ic_players),
        LegendItem("Verified", R.drawable.ic_verified),
        LegendItem("Commit", R.drawable.ic_verified),
        LegendItem("Video", R.drawable.ic_video, "DE0000"),
        LegendItem("Note", R.drawable.ic_verified),
        LegendItem("Info", R.drawable.ic_verified),

//    LegendItem(name: "Valid", icon: ImageHelper.valid, color: .green),
//    LegendItem(name: "Invalid", icon: ImageHelper.invalid, color: .red),
//    LegendItem(name: "Bookmark/Save", icon: ImageHelper.bookmark),
//    LegendItem(name: "View", icon: ImageHelper.view),
//    LegendItem(name: "Share", icon: ImageHelper.share),
//    LegendItem(name: "Tag", icon: ImageHelper.tag),
//    LegendItem(name: "Notification", icon: ImageHelper.notification),
//    LegendItem(name: "Coach", icon: ImageHelper.coach),
//    LegendItem(name: "Club", icon: ImageHelper.club),
//    LegendItem(name: "Filter", icon: ImageHelper.filter),
//    LegendItem(name: "Sort", icon: ImageHelper.sort),
//    LegendItem(name: "College", icon: ImageHelper.college),
//    LegendItem(name: "Player", icon: ImageHelper.players),
//    LegendItem(name: "Verified", icon: ImageHelper.verified),
//    LegendItem(name: "Commit", icon: ImageHelper.commit, color: .yellow),
//    LegendItem(name: "Video", icon: ImageHelper.video, color: .utrRed),
//    LegendItem(name: "Note", icon: ImageHelper.note),
//    LegendItem(name: "Info", icon: ImageHelper.info),
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
        for (item in legendItems) {
            val tv = TextView(context)
            tv.text = item.name
            linearLayout.addView(tv)
        }

        val bottomView = View(context)
        val params = LayoutParams(50, 100)
        bottomView.layoutParams = params
        linearLayout.addView(bottomView)
        return binding.root
    }
}