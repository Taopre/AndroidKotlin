package com.example.android_kotlin.di.module

import android.app.Activity
import android.content.Context
import com.example.android_kotlin.di.ActivityContext
import com.example.android_kotlin.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity
}
