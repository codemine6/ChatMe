package com.kuswand.chatme.presentation.sign_in

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)