package com.kuswand.chatme.presentation.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun setEmail(email: String) {
        _state.value = state.value.copy(email = email)
    }

    fun setPassword(password: String) {
        _state.value = state.value.copy(password = password)
    }

    fun signInWithEmail() {
        _state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            authUseCases.signInWithEmail("", "")
        }
    }
}