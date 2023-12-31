package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.CollegeConference
import com.example.underradarandroid.DataClasses.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getUsers() {
    Firebase.firestore.collection(usersCollection).get()
        .addOnSuccessListener { result ->
            try {
                usersObservable.value = result.toObjects(User::class.java).toTypedArray()

                Log.d("UR Logging Users", usersObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got users")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}

fun DatabaseManager.getUserForId(id: String): User? {
    return usersObservable.value?.firstOrNull() { id == it.id }
}