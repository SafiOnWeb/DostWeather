package com.safi.apps.clients.dost.weather

import android.app.Application
import com.safi.apps.clients.dost.weather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@WeatherApp)
            modules(appModule)
        }
    }
}