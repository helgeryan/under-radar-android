package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.CollegeConference
import com.example.underradarandroid.DataClasses.Event
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getEvents() {
    Firebase.firestore.collection(eventsCollection).get()
        .addOnSuccessListener { result ->
            try {
                eventsObservable.value = result.toObjects(Event::class.java).toTypedArray()

                Log.d("UR Logging Events", eventsObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got events")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}

fun DatabaseManager.getEventForId(id: String): Event? {
    return eventsObservable.value?.firstOrNull() { id == it.id }
}