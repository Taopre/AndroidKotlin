package com.example.android_kotlin.ui.mainTab.home

import com.example.android_kotlin.model.Pet
import com.example.android_kotlin.ui.base.MvpView

interface TabHomeMvpView : MvpView{
    fun updatePetList(petList : ArrayList<Pet>)
}
