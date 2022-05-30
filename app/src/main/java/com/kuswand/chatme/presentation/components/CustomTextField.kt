package com.kuswand.chatme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.kuswand.chatme.R

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    pattern: Regex,
    keyboardType: KeyboardType = KeyboardType.Text,
    transformation: Boolean = false
) {
    var showValue by remember { mutableStateOf(!transformation) }
    var valid by remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        if (value.isNotBlank()) text = value
    }

    Row(
        Modifier
            .border(
                1.dp,
                if (valid) MaterialTheme.colors.secondary.copy(.5f) else MaterialTheme.colors.error,
                RoundedCornerShape(8.dp)
            )
            .background(MaterialTheme.colors.surface, RoundedCornerShape(8.dp))
            .padding(18.dp, 16.dp)
    ) {
        Box(Modifier.weight(1f)) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    valid = pattern.containsMatchIn(it)
                    if (valid) {
                        onValueChange(it)
                    } else {
                        onValueChange("")
                    }
                },
                textStyle = MaterialTheme.typography.body1,
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                singleLine = true,
                visualTransformation = if (showValue) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            if (text.isBlank()) {
                Text(
                    text = placeholder,
                    color = MaterialTheme.colors.secondary
                )
            }
        }
        if (transformation) {
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(
                    id = if (showValue) R.drawable.ic_eye else R.drawable.ic_eye_crossed
                ),
                contentDescription = "",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .size(16.dp)
                    .clickable { showValue = !showValue }
            )
        }
    }
}