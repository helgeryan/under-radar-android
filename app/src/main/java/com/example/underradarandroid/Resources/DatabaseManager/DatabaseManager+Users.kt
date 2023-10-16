package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getUsers() {
    Firebase.firestore.collection(usersCollection).get()
        .addOnSuccessListener { result ->
            try {
                users = result.toObjects(User::class.java).toTypedArray()

                Log.d("UR Logging", users.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got users")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}