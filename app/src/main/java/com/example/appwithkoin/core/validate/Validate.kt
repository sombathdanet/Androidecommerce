package com.example.appwithkoin.core.validate
import android.util.Patterns

class Validate {
    fun  isEmailValidate(email:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isPhoneNumber(value: String):Boolean{
        return value.any { it.isDigit() }
    }
}