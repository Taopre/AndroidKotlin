package com.example.android_kotlin.ui.mainTab.repo

import android.view.View
import com.example.android_kotlin.Networking.GithubAPI
import com.example.android_kotlin.model.Pet
import com.example.android_kotlin.rx.RxThread
import com.example.android_kotlin.ui.base.BasePresenter
import com.example.android_kotlin.ui.base.MvpView
import com.example.android_kotlin.utils.URL

import javax.inject.Inject


class TabRepoPresenter<V : TabRepoMvpView> @Inject constructor(private val api: GithubAPI, private val rxThread: RxThread):
    BasePresenter<V>(), TabRepoMvpPresenter<V> {

    private lateinit var view: TabRepoMvpView

    // pets 데이터를 가져와서 뷰로 전달
    override fun loadData(user: String) {
        // mvpView!!.updatePetList(petList)
        compositeDisposable.add(api.getRepo(user)
            .compose(rxThread.applyAsync())
            .doOnTerminate { //view.dismissLoading()
            }
            .onErrorReturnItem(emptyList())
            .subscribe { view.showRepo(it) }
        )
    }

    fun getRepo(user: String) {


    }


    fun injectView(view: TabRepoMvpView) {
        this.view = view
    }
    fun onStop() {
        compositeDisposable.clear()
    }
}

