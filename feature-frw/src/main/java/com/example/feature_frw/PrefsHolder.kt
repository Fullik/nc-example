package com.example.feature_frw

import android.content.Context
import android.content.SharedPreferences

class PrefsHolder(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("navigation_test", Context.MODE_PRIVATE)

    fun isFrwCompleted(): Boolean {
        return prefs.getBoolean("frw_completed", false)
    }

    fun setFrwCompleted(value: Boolean) {
        prefs.edit().putBoolean("frw_completed", value).apply()
    }

    fun frwStage(): Int {
        return prefs.getInt("frw_stage", 0)
    }

    fun setFrwStage(stage: Int) {
        prefs.edit().putInt("frw_stage", stage).apply()
    }

    companion object {
        lateinit var holder: PrefsHolder

        fun initHolder(context: Context) {
            holder = PrefsHolder(context)
        }
    }
}