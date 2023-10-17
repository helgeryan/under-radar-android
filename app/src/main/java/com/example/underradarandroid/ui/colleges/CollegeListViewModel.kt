package com.example.underradarandroid.ui.colleges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CollegeListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is colleges Fragment"
    }
    val text: LiveData<String> = _text
}