package com.example.ui.gameshub

import android.content.Context
import android.content.SharedPreferences

object StarScoreManager {

    private const val PREFS_NAME = "wonderplay_prefs"
    private const val KEY_TOTAL_STARS = "TOTAL_STARS"
    private const val DEFAULT_VALUE = 0

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getTotalStars(context: Context): Int {
        val sharedPreferences = getPreferences(context)
        return sharedPreferences.getInt(KEY_TOTAL_STARS, DEFAULT_VALUE)
    }

    fun addStars(context: Context, starsToAdd: Int) {
        if (starsToAdd < 0) return // Prevent negative increments

        val sharedPreferences = getPreferences(context)
        val currentStars = sharedPreferences.getInt(KEY_TOTAL_STARS, DEFAULT_VALUE)
        val newTotal = (currentStars + starsToAdd).coerceAtLeast(0) // Prevent negative totals

        sharedPreferences.edit().putInt(KEY_TOTAL_STARS, newTotal).apply()
    }

    fun resetStars(context: Context) {
        val sharedPreferences = getPreferences(context)
        sharedPreferences.edit().putInt(KEY_TOTAL_STARS, DEFAULT_VALUE).apply()
    }
}