
package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
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
     var clubs: Array<Club> = arrayOf()
     var users: Array<User> = arrayOf()
     var colleges: Array<College> = arrayOf()
     var stories: Array<Story> = arrayOf()
     var events: Array<Event> = arrayOf()
     var savedEvents: Array<SavedEvent> = arrayOf()
     var notifications: Array<UserNotification> = arrayOf()
     var collegeConferences: Array<CollegeConference> = arrayOf()

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
     }
}