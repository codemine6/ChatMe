package com.kuswand.chatme.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.kuswand.chatme.presentation.destinations.SignInScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    LaunchedEffect(true) {
        navigator.navigate(SignInScreenDestination)
    }
    Scaffold { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item {
                Button(
                    onClick = {
                        navigator.navigate(SignInScreenDestination)
                    }
                ) {
                    Text(text = "Sign In")
                }
            }
        }
    }
}