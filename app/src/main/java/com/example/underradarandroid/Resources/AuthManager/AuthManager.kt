package com.example.underradarandroid.Resources.AuthManager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.json.JSONObject
import java.io.Serializable

object AuthManager {
    private val auth: FirebaseAuth = Firebase.auth

    private var userSession: FirebaseUser? = auth.currentUser
    private var currentUser = MutableLiveData<User?>()
    val readUser : LiveData<User?> get() = currentUser

    init {
        fetchUser()
    }

    fun isLoggedIn(): Boolean {
        return auth.currentUser != null
    }

    fun refresh() {

    }

    fun login(email: String, password: String, completion: (Boolean) -> Unit) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        fetchUser()
                        completion(true)
                    } else {
                        // If sign in fails, display a message to the user.
                        completion(false)
                    }
                }
    }

    fun createUser(email: String, password: String, firstName: String, lastName: String, profileType: Int, completion: () -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { result ->
                userSession = result.user
                val user = User(result.user!!.uid, firstName, lastName, email, "", 1)
                Firebase.firestore.collection(DatabaseManager.usersCollection).document(user.id)
                    .set(user)
                    .addOnSuccessListener {
                        fetchUser()
                        completion()
                    }
                    .addOnFailureListener {

                    }
            }
            .addOnFailureListener {

            }
    }


    fun logout() {
        auth.signOut()
        currentUser.value = null
        userSession = null
    }

    private fun fetchUser() {
        val id = auth.currentUser?.uid

        if (id == null) {
            currentUser.value = null
            return
        }

        id?.let {
            Firebase.firestore.collection(DatabaseManager.usersCollection).document(id).get()
                .addOnSuccessListener { result ->
                    try {
                        currentUser.value = result.toObject(User::class.java)
                    } catch (e: RuntimeException) {
                        Log.d("Error", e.message.toString())
                    }

                    Log.d("Under Radar", "Successfully got user")
                }
                .addOnFailureListener { error ->
                    print("Error")
                }
        }
    }
}