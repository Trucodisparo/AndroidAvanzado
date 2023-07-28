package com.keepcoding.androidsuperpoderes.presentation.forgotPassword

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ForgotPasswordScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(modifier = Modifier.align(Alignment.Center), text = "Forgot password")
    }
}