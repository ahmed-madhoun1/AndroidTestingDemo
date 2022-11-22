package com.ahmedmadhoun.androidtestingdemo

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `valid username and correctly repeated password returns true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ahmed",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username already exist returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ali",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ahmed",
            password = "",
            confirmedPassword = ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ahmed",
            password = "123456",
            confirmedPassword = "222222"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digits password returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ahmed",
            password = "abcd5",
            confirmedPassword = "abcd5"
        )
        assertThat(result).isFalse()
    }

}