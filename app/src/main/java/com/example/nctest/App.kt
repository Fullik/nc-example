package com.example.nctest

import android.app.Application
import com.example.feature_frw.PrefsHolder

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PrefsHolder.initHolder(this)
    }
}