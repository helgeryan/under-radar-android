package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.Event
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getEvents() {
    Firebase.firestore.collection(eventsCollection).get()
        .addOnSuccessListener { result ->
            try {
                events = result.toObjects(Event::class.java).toTypedArray()

                Log.d("UR Logging", events.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got events")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}
