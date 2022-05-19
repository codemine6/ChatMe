package com.kuswand.chatme.presentation.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuswand.chatme.domain.use_case.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

    init {
        signInWithEmail()
    }

    private fun signInWithEmail() {
        viewModelScope.launch {
            authUseCases.signInWithEmail("", "")
        }
    }
}