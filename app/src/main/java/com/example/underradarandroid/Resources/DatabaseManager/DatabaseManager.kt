
package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.underradarandroid.DataClasses.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DatabaseManager {
     const val storiesCollection: String = "headlines"
     const val conferenceCollection: String = "collegeConferences"
     const val usersCollection: String = "users"
     const val eventsCollection: String = "events"
     const val clubsCollection: String = "clubs"
     const val collegesCollection: String = "colleges"
     const val savedEventsCollection: String = "savedEvents"
     const val notificationsCollection: String = "notifications"
     const val bookmarksCollection: String = "bookmarks"

     var eventsObservable = MutableLiveData<Array<Event>>()
     val readEvents : LiveData<Array<Event>> get() = eventsObservable

     var usersObservable = MutableLiveData<Array<User>>()
     val readUsers: LiveData<Array<User>> get() = usersObservable
     var clubsObservable = MutableLiveData<Array<Club>>()
     val readClubs: LiveData<Array<Club>> get() = clubsObservable
     var collegesObservable = MutableLiveData<Array<College>>()
     val readCollege: LiveData<Array<College>> get() = collegesObservable
     var notificationsObservable = MutableLiveData<Array<UserNotification>>()
     val readNotifications: LiveData<Array<UserNotification>> get() = notificationsObservable
     var savedEventsObservable = MutableLiveData<Array<SavedEvent>>()
     val readSavedEvents: LiveData<Array<SavedEvent>> get() = savedEventsObservable
     var storiesObservable = MutableLiveData<Array<Story>>()
     val readStories: LiveData<Array<Story>> get() = storiesObservable
     var conferencesObservable = MutableLiveData<Array<CollegeConference>>()
     val readConferences: LiveData<Array<CollegeConference>> get() = conferencesObservable
     var bookmarksObservable = MutableLiveData<Array<Bookmark>>()
     val readBookmarks: LiveData<Array<Bookmark>> get() = bookmarksObservable

     init {

     }

     fun refresh() {
          getConferences()
          getUsers()
          getStories()
          getEvents()
          getColleges()
          getClubs()

          getNotifications("qyq883mpZqQlxjkBV2RcSdio4eV2")
          getSavedEvents("qyq883mpZqQlxjkBV2RcSdio4eV2")
          getBookmarks("qyq883mpZqQlxjkBV2RcSdio4eV2")
     }
}