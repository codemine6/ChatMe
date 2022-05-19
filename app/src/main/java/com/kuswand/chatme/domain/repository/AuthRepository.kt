package com.kuswand.chatme.domain.repository

interface AuthRepository {
    suspend fun signInWithEmail(email: String, password: String)
}