package com.example.underradarandroid.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.underradarandroid.R


class Fragment1(id: Int) : Fragment() {
    private val resourceId: Int = id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        when(resourceId) {
            0 -> imageView.setImageResource(R.drawable.carousel1)
            1 -> imageView.setImageResource(R.drawable.carousel2)
            2 -> imageView.setImageResource(R.drawable.carousel3)
            else -> imageView.setImageResource(R.drawable.carousel1)
        }

    }
}