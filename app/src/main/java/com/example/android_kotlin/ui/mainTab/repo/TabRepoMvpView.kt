package com.example.android_kotlin.ui.mainTab.repo

import com.example.android_kotlin.model.Pet
import com.example.android_kotlin.model.Repo
import com.example.android_kotlin.ui.base.MvpView

interface TabRepoMvpView : MvpView{
    fun showRepo(repoList: List<Repo>)
    fun configurationRecyclerView()
    fun getRepoInfo()
}
