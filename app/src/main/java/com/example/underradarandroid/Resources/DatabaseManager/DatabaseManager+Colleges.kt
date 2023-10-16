package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.College
import com.example.underradarandroid.DataClasses.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getColleges() {
    Firebase.firestore.collection(collegesCollection).get()
        .addOnSuccessListener { result ->
            try {
                colleges = result.toObjects(College::class.java).toTypedArray()

                Log.d("UR Logging", colleges.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got colleges")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}