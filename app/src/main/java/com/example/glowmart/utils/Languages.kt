package com.example.glowmart.utils

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

fun loadLocale(context: Context) {
    val sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
    val language = sharedPreferences.getString("My_Lang", "en")
    setLocale(context, language)
}

fun setLocale(context: Context, languageCode: String?) {
    val locale = languageCode?.let { Locale(it) }
    if (locale != null) {
        Locale.setDefault(locale)
    }
    val config = Configuration()
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}