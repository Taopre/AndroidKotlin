package com.example.android_kotlin

import android.app.Application
import com.example.android_kotlin.di.component.AppComponent
import com.example.android_kotlin.di.component.DaggerAppComponent
import com.example.android_kotlin.di.module.ApplicationModule
import com.example.android_kotlin.di.module.HttpModule


open class MainApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        createComponent()
    }

    protected open fun createComponent() {
        component = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .httpModule(HttpModule())
                .build()

    }
}

