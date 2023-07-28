package com.keepcoding.androidsuperpoderes.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keepcoding.androidsuperpoderes.R
import com.keepcoding.androidsuperpoderes.ui.theme.AndroidSuperPoderesTheme
import androidx.compose.runtime.*

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onForgot: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize().background(Color(170,250,170)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        LoginHeader()
        Spacer(modifier = Modifier.size(20.dp))
        LoginFields(onLoginSuccess, onForgot)
    }
}

@Composable
fun LoginHeader(){
    Image(
        modifier = Modifier
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)
            .background(Color.Green),
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Logo Image"
    )
    Text(
        text = "Android Superpoderes",
        textAlign = TextAlign.Center,
    )
}

@Composable
fun LoginFields(
    onLoginSuccess: () -> Unit,
    onForgot: () -> Unit
){
    var email by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}
    var passwordVisible by remember{ mutableStateOf(false) }

    TextField(value = email,
        onValueChange = {email = it},
        label = {Text("Email")},
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "emailIcon")},
    )
    TextField(value = password,
        onValueChange = {password = it},
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        label = { Text("Password")},
        leadingIcon = { Icon(painter = painterResource(id = R.drawable.baseline_password_24), contentDescription = "passwordIcon")},
        trailingIcon = {
            val icon = if(passwordVisible)
                Icon(painter = painterResource(id = R.drawable.baseline_visibility_24), contentDescription = "passwordIcon")
            else
                Icon(painter = painterResource(id = R.drawable.baseline_visibility_off_24), contentDescription = "passwordIcon")
            IconButton(onClick = {passwordVisible = !passwordVisible}, content = {icon})
        }
    )
    Spacer(modifier = Modifier.size(20.dp))
    Button(
        onClick = { onLoginSuccess() },
        colors = ButtonDefaults.buttonColors(Color(30, 100, 30))
    ){
        Text("Login")
    }
    Button(
        onClick = { onForgot() },
        colors = ButtonDefaults.buttonColors(Color(30, 100, 30))
    ){
        Text("Forgot Password")
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    AndroidSuperPoderesTheme() {
        LoginScreen({}, {})
    }
}