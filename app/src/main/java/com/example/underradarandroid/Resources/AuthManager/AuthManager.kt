package com.example.underradarandroid.Resources.AuthManager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.CollegeConference
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.DataClasses.SavedEvent
import com.example.underradarandroid.DataClasses.Story
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.DataClasses.UserNotification

object AuthManager {
    const val storiesCollection: String = "headlines"

    var currentUser = MutableLiveData<User?>()
    val readUser : LiveData<User?> get() = currentUser

    fun isLoggedIn(): Boolean {
        return false
    }

    fun refresh() {

    }
}