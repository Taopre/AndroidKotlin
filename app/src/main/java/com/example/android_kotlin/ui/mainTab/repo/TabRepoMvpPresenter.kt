package com.example.android_kotlin.ui.mainTab.repo

import com.example.android_kotlin.ui.base.MvpPresenter

interface TabRepoMvpPresenter<V : TabRepoMvpView> : MvpPresenter<V>{
    fun loadData(user:String)
}
