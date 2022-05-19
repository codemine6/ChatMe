package com.kuswand.chatme.presentation.sign_in

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignInScreen(
    navigator: DestinationsNavigator,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Scaffold { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item {
                Button(
                    onClick = {
                        navigator.popBackStack()
                    }
                ) {
                    Text(text = "Back")
                }
            }
        }
    }
}