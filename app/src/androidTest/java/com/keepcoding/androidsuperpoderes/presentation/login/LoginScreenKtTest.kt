package com.keepcoding.androidsuperpoderes.presentation.login

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test

class LoginScreenKtTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testLoginSuccess(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgot = {})
        }
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_USER").performTextInput("alextfos@keepcoding.io")
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_PASSWORD").performTextInput("password")

        rule.onNodeWithText("Login").performClick()

        assertThat(logged, `is`(true))
    }

    @Test
    fun testLoginFailEmptyStrings(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgot = {})
        }

        rule.onNodeWithText("Login").performClick()

        assertThat(logged, `is`(false))
    }

    @Test
    fun testLoginFailWrongEmail(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgot = {})
        }
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_USER").performTextInput("erica@keepcoding.io")
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_PASSWORD").performTextInput("password")

        rule.onNodeWithText("Login").performClick()

        assertThat(logged, `is`(false))
    }

    @Test
    fun testLoginFailWrongPassword(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgot = {})
        }
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_USER").performTextInput("alextfos@keepcoding.io")
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_PASSWORD").performTextInput("wrongpassword")

        rule.onNodeWithText("Login").performClick()

        assertThat(logged, `is`(false))
    }

    @Test
    fun testLoginFailOnlyEmail(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgot = {})
        }
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_USER").performTextInput("erica@keepcoding.io")

        rule.onNodeWithText("Login").performClick()

        assertThat(logged, `is`(false))
    }

    @Test
    fun testLoginFailOnlyPassword(){
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgot = {})
        }
        rule.onNodeWithTag("LOGIN_TEXT_FIELD_PASSWORD").performTextInput("password")

        rule.onNodeWithText("Login").performClick()

        assertThat(logged, `is`(false))
    }
}