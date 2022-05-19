package com.kuswand.chatme.domain.use_case.auth

import com.kuswand.chatme.domain.repository.AuthRepository

class SignInWithEmail(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        return repository.signInWithEmail(email, password)
    }
}