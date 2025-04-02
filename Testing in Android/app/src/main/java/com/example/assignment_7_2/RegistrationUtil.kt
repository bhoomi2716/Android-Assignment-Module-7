package com.example.assignment_7_2

class RegistrationUtil
{
    private val existingUsers = listOf("abc")

    fun validRegistrationInput(
        userName : String,
        password : String,
        confirmPassword : String
    ) : Boolean
    {
        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            return false
        }

        if (userName in existingUsers){
            return false
        }

        if (password != confirmPassword){
            return false
        }

        if (password.count { it.isDigit() } < 2){
            return false
        }
        return true
    }
}