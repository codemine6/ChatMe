package com.kuswand.chatme.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kuswand.chatme.presentation.ui.theme.ChatMeTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatMeTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}