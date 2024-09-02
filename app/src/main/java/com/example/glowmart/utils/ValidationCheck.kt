package com.example.glowmart.utils

import android.util.Patterns

fun validateEmail(email : String) : RegisterValidation {
    if (email.isEmpty())
        return RegisterValidation.Failed("Email is required")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failed("Wrong email format")

    return RegisterValidation.Success
}

fun validatePassword(password : String) : RegisterValidation {
    if (password.isEmpty())
        return RegisterValidation.Failed("Password is required")

    if (password.length < 6)
        return RegisterValidation.Failed("Password must be at least 6 characters")

    return RegisterValidation.Success
}