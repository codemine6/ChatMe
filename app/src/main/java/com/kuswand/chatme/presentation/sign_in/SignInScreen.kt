package com.kuswand.chatme.presentation.sign_in

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kuswand.chatme.R
import com.kuswand.chatme.presentation.components.CustomButton
import com.kuswand.chatme.presentation.components.CustomTextField
import com.kuswand.chatme.presentation.components.Loader
import com.kuswand.chatme.presentation.sign_in.components.SignOption
import com.kuswand.chatme.utils.Constants
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignInScreen(
    navigator: DestinationsNavigator,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val state by viewModel.state

    Scaffold { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item {
                Spacer(modifier = Modifier.height(96.dp))
                Text(
                    text = stringResource(id = R.string.sign_in_title),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(48.dp))
            }
            item {
                Column(Modifier.padding(horizontal = 36.dp)) {
                    CustomTextField(
                        value = state.email,
                        onValueChange = { viewModel.setEmail(it) },
                        placeholder = stringResource(id = R.string.email),
                        pattern = Constants.EMAIL_PATTERN,
                        keyboardType = KeyboardType.Email
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomTextField(
                        value = state.password,
                        onValueChange = { viewModel.setPassword(it) },
                        placeholder = stringResource(id = R.string.password),
                        pattern = Constants.PASSWORD_PATTERN,
                        transformation = true
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable {}
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = stringResource(id = R.string.or_continue_with),
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SignOption(
                        icon = painterResource(id = R.drawable.ic_facebook),
                        title = stringResource(id = R.string.facebook),
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    SignOption(
                        icon = painterResource(id = R.drawable.ic_google),
                        title = stringResource(id = R.string.google),
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.height(48.dp))
            }
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomButton(
                        onClick = { viewModel.signInWithEmail() }
                    ) {
                        Text(text = stringResource(id = R.string.sign_in))
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = stringResource(id = R.string.no_have_account),
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable {}
                    )
                }
            }
        }
        Loader(visible = state.isLoading)
    }
}