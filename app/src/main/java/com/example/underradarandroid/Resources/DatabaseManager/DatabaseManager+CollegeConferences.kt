package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.CollegeConference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getConferences() {
    Firebase.firestore.collection(conferenceCollection).get()
        .addOnSuccessListener { result ->
            try {
                collegeConferences = result.toObjects(CollegeConference::class.java).toTypedArray()

                Log.d("UR Logging Conferences", collegeConferences.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got conferences")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}

fun DatabaseManager.getConferenceForId(id: String): CollegeConference? {
    return collegeConferences.firstOrNull() { id == it.id }
}