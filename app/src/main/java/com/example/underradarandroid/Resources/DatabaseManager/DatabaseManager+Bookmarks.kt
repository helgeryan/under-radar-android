package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.Bookmark
import com.example.underradarandroid.DataClasses.SavedEvent
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


fun DatabaseManager.getBookmarks(userId: String) {
    Firebase.firestore.collection(bookmarksCollection).whereEqualTo("userId", userId).get()
        .addOnSuccessListener { result ->
            try {
                bookmarksObservable.value = result.toObjects(Bookmark::class.java).toTypedArray()
                Log.d("UR Logging Saved Events", bookmarksObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got saved events")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}