package com.example.underradarandroid.Resources.DatabaseManager

import android.util.Log
import com.example.underradarandroid.DataClasses.Club
import com.example.underradarandroid.DataClasses.UserNotification
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun DatabaseManager.getNotifications(userId: String) {
    Firebase.firestore.collection(notificationsCollection).whereEqualTo("userId", userId).get()
        .addOnSuccessListener { result ->
            try {
                notificationsObservable.value = result.toObjects(UserNotification::class.java).toTypedArray()

                Log.d("UR Logging Notifications", notificationsObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got notifications")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}