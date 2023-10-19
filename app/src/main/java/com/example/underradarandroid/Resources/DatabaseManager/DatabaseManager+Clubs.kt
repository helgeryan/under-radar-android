package com.example.underradarandroid.Resources.DatabaseManager

import com.example.underradarandroid.DataClasses.Club
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getClubs() {
    Firebase.firestore.collection(clubsCollection).get()
        .addOnSuccessListener { result ->
            try {
                clubsObservable.value = result.toObjects(Club::class.java).toTypedArray()

                Log.d("UR Logging Clubs", clubsObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got clubs")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}
