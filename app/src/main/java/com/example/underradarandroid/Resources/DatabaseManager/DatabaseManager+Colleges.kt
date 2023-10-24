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
                collegesObservable.value = result.toObjects(College::class.java).toTypedArray()

                Log.d("UR Logging Colleges", collegesObservable.value?.size.toString())
            } catch (e: RuntimeException) {
                Log.d("Error", e.message.toString())
            }

            Log.d("Under Radar", "Successfully got colleges")
        }
        .addOnFailureListener { error ->
            print("Error")
        }
}

fun DatabaseManager.getPlayersForCollege(id: String): Array<User>? {
    return usersObservable.value?.filter() { user ->
        user.currentCollegeId == id && user.isPlayer()
    }?.toTypedArray()
}

fun DatabaseManager.getCoachesForCollege(id: String): Array<User>? {
    return usersObservable.value?.filter() { user ->
        user.college == id && user.isCoach()
    }?.toTypedArray()
}

fun DatabaseManager.getCommitmentsForCollege(id: String): Array<User>? {
    return usersObservable.value?.filter() { user ->
        user.isPlayer() && user.collegeCommit == id
    }?.toTypedArray()
}