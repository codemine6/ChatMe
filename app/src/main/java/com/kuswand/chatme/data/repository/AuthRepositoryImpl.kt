package com.kuswand.chatme.data.repository

import com.kuswand.chatme.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override suspend fun signInWithEmail(email: String, password: String) {}
}