package com.alpha.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoreApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
