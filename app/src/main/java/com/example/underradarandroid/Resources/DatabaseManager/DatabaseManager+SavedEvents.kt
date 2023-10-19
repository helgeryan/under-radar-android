package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.SavedEvent
import com.example.underradarandroid.DataClasses.UserNotification
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getSavedEvents(userId: String) {
    Firebase.firestore.collection(savedEventsCollection).whereEqualTo("userId", userId).get()
        .addOnSuccessListener { result ->
            try {
                savedEventsObservable.value = result.toObjects(SavedEvent::class.java).toTypedArray()
                Log.d("UR Logging Saved Events", savedEventsObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got saved events")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}