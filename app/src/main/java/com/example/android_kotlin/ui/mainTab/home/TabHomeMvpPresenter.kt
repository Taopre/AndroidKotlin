package com.example.android_kotlin.ui.mainTab.home

import com.example.android_kotlin.ui.base.MvpPresenter

interface TabHomeMvpPresenter<V : TabHomeMvpView> : MvpPresenter<V>{
    fun loadData()
}
