package com.example.underradarandroid.ui.players

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is colleges Fragment"
    }
    val text: LiveData<String> = _text
}