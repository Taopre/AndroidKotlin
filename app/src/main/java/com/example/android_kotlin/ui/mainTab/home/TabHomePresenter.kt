package com.example.android_kotlin.ui.mainTab.home

import android.view.View
import com.example.android_kotlin.model.Pet
import com.example.android_kotlin.rx.RxThread
import com.example.android_kotlin.ui.base.BasePresenter
import com.example.android_kotlin.ui.base.MvpView
import com.example.android_kotlin.utils.URL

import javax.inject.Inject


class TabHomePresenter<V : TabHomeMvpView> @Inject constructor(private val rxThread: RxThread):
    BasePresenter<V>(), TabHomeMvpPresenter<V> {

    private lateinit var view: MvpView

    // pets 데이터를 가져와서 뷰로 전달
    override fun loadData() {

        var petImage = URL.BASE_URL +"petImage/russian_blue.jpg"
        val pet1 = Pet(petImage, "Russian blue", "short hair", 1, 0)


        petImage = URL.BASE_URL +"petImage/scottish_fold.jpg"
        val pet2 = Pet(petImage, "Scottish Fold", "short hair", 1, 1)

        val petList : ArrayList<Pet> = arrayListOf(pet1,pet2)
//        petList?.add(pet)

        mvpView!!.updatePetList(petList)
    }

    fun injectView(view: MvpView) {
        this.view = view
    }
}

