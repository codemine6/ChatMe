package com.kuswand.chatme.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Loader(
    visible: Boolean
) {
    val circles = listOf(
        remember { Animatable(0f) },
        remember { Animatable(0f) },
        remember { Animatable(0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    keyframes {
                        durationMillis = 1200
                        0f at 0 with LinearOutSlowInEasing
                        1f at 300 with LinearOutSlowInEasing
                        0f at 600 with LinearOutSlowInEasing
                        0f at 1200 with LinearOutSlowInEasing
                    }
                )
            )
        }
    }

    if (visible) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .size(66.dp)
                    .background(MaterialTheme.colors.surface.copy(.7f), RoundedCornerShape(24.dp))
            ) {
                circles
                    .map { it.value }
                    .forEachIndexed { index, value ->
                        Box(
                            Modifier
                                .size(10.dp)
                                .graphicsLayer {
                                    translationY = -value * 10.dp.toPx()
                                }
                                .background(MaterialTheme.colors.primary, CircleShape)
                        )
                        if (index != 2) {
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
            }
        }
    }
}