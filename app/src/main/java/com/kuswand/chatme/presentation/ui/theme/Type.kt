package com.kuswand.chatme.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.kuswand.chatme.R

val Typography = Typography(
    subtitle2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.rubik_bold)),
        fontSize = 15.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.rubik_regular)),
        fontSize = 14.sp
    )
)