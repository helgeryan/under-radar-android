package com.example.underradarandroid.Resources.DatabaseManager

import com.example.underradarandroid.DataClasses.Club
import android.util.Log
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.DataClasses.UserHelper
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.io.Serializable

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

fun DatabaseManager.getPlayersForClub(id: String): Array<User>? {
    return usersObservable.value?.filter() { user ->
        user.club == id && UserHelper(user).isPlayer()
    }?.toTypedArray()
}

fun DatabaseManager.getCoachesForClub(id: String): Array<User>? {
    return usersObservable.value?.filter() { user ->
        user.club == id && UserHelper(user).isCoach()
    }?.toTypedArray()
}

fun DatabaseManager.getCommitmentsForClub(id: String): Array<User>? {
    return usersObservable.value?.filter() { user ->
        user.club == id && user.collegeCommit != null
    }?.toTypedArray()
}
