package com.karanchuk.roman.testtranslate.presentation

import android.app.Application
import com.karanchuk.roman.testtranslate.di.AppComponent
import com.karanchuk.roman.testtranslate.di.DaggerAppComponent
import com.karanchuk.roman.testtranslate.di.DatabaseModule
import com.karanchuk.roman.testtranslate.di.NetworkModule


class TestTranslatorApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var instance: TestTranslatorApp
    }

    override fun onCreate() {
        super.onCreate()

        initDagger()
        instance = this
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .databaseModule(DatabaseModule())
                .build()
    }
}