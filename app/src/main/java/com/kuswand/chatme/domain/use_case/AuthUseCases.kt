package com.kuswand.chatme.domain.use_case

import com.kuswand.chatme.domain.use_case.auth.SignInWithEmail

data class AuthUseCases(
    val signInWithEmail: SignInWithEmail
)