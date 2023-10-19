package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.Story
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getStories() {
    Firebase.firestore.collection(storiesCollection).get()
        .addOnSuccessListener { result ->
            try {
                stories = result.toObjects(Story::class.java).toTypedArray()

                Log.d("UR Logging Stories", stories.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got stories")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}