package com.example.underradarandroid.ui.clubs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClubListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is clubs Fragment"
    }
    val text: LiveData<String> = _text
}