package com.kuswand.chatme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        Modifier
            .clip(CircleShape)
            .background(
                Brush.horizontalGradient(
                    listOf(MaterialTheme.colors.primary.copy(.6f), MaterialTheme.colors.primary)
                )
            )
            .clickable { onClick() }
            .padding(28.dp, 14.dp)
    ) {
        ProvideTextStyle(value = MaterialTheme.typography.subtitle2) {
            Surface(
                color = Color.Transparent,
                contentColor = MaterialTheme.colors.surface,
                content = content
            )
        }
    }
}