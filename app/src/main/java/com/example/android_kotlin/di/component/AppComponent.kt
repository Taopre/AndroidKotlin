package com.example.android_kotlin.di.component

import com.example.android_kotlin.di.module.*
import com.example.android_kotlin.ui.main.MainActivity
import com.example.android_kotlin.ui.mainTab.dogs.TabDogsFragment
import com.example.android_kotlin.ui.mainTab.home.TabHomeFragment

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(HttpModule::class,
        ApplicationModule::class, AndroidModule::class,
        RxThreadModule::class))

/*@Singleton
@Component(modules = arrayOf(AppModule::class))*/

interface AppComponent {
    fun inject(fragment: TabHomeFragment)

    fun inject(activity: MainActivity)

    fun inject(fragment: TabDogsFragment)
}