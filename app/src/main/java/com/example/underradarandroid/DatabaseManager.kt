
package com.example.underradarandroid

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DatabaseManager {
     val storiesCollection: String = "headlines"
     val usersCollection: String = "users"
     val eventsCollection: String = "events"
     val clubsCollection: String = "clubs"
     val collegesCollection: String = "colleges"
     val savedEventsCollection: String = "savedEvents"
     val notificationsCollection: String = "notifications"
     init {

     }

     fun refresh() {
          getUsers()
          getStories()
          getEvents()
          getNotifications()
          getColleges()
          getClubs()
     }
}

fun getUsers() {
     Firebase.firestore.collection(DatabaseManager.usersCollection).get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "User")
               }
          }
          .addOnFailureListener { error ->
               print("Error")
          }
}

fun getStories() {
     Firebase.firestore.collection(DatabaseManager.storiesCollection).get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "Story")
               }
          }
          .addOnFailureListener { error ->
               print("Error")
          }
}

fun getEvents() {
     Firebase.firestore.collection(DatabaseManager.storiesCollection).get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "Events")
               }
          }
          .addOnFailureListener { error ->
               print("Error")
          }
}

fun getNotifications() {
     Firebase.firestore.collection(DatabaseManager.notificationsCollection).whereEqualTo("userId", "qyq883mpZqQlxjkBV2RcSdio4eV2").get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "Notifications")
               }
          }
          .addOnFailureListener { error ->
               print("Error")
          }
}


fun getClubs() {
     Firebase.firestore.collection(DatabaseManager.clubsCollection).get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "Clubs")
               }
          }
          .addOnFailureListener { error ->
               print("Error")
          }
}


fun getColleges() {
     Firebase.firestore.collection(DatabaseManager.collegesCollection).get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "Colleges")
               }
          }
          .addOnFailureListener { error ->
               print("Error")
          }
}