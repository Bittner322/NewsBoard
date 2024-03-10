package com.mikhail.newsboard

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class AuthService {
    private val auth: FirebaseAuth = Firebase.auth

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun signOutUser() {
        auth.signOut()
    }

    suspend fun registerUser(email: String, password: String): FirebaseUser {
        return suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(FirebaseAuthExecutor()) { task ->
                    if (task.isSuccessful) {
                        continuation.resume(task.result.user!!)
                    } else {
                        continuation.resumeWithException(task.exception!!)
                    }
                }
        }
    }

    suspend fun signInUser(email: String, password: String): FirebaseUser {
        return suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(FirebaseAuthExecutor()) { task ->
                    if (task.isSuccessful) {
                        continuation.resume(task.result.user!!)
                    } else {
                        continuation.resumeWithException(task.exception!!)
                    }
                }
        }
    }
}