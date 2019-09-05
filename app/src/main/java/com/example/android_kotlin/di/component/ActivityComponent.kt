package com.example.android_kotlin.di.component

import com.example.android_kotlin.di.PerActivity
import com.example.android_kotlin.di.module.ActivityModule
import dagger.Component

@PerActivity
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent
