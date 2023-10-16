
package com.example.underradarandroid

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DatabaseManager {
     const val storiesCollection: String = "headlines"
     const val usersCollection: String = "users"
     const val eventsCollection: String = "events"
     const val clubsCollection: String = "clubs"
     const val collegesCollection: String = "colleges"
     const val savedEventsCollection: String = "savedEvents"
     const val notificationsCollection: String = "notifications"
     init {

     }

     fun refresh() {
          getUsers()
          getStories()
          getEvents()
          getNotifications()
          getColleges()
          getClubs()
          getSavedEvents()
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
     Firebase.firestore.collection(DatabaseManager.eventsCollection).get()
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

fun getSavedEvents() {
     Firebase.firestore.collection(DatabaseManager.savedEventsCollection).whereEqualTo("userId", "qyq883mpZqQlxjkBV2RcSdio4eV2").get()
          .addOnSuccessListener { result ->
               for (document in result) {
                    Log.d("ok", "Saved Events")
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