package com.example.android_kotlin.rx

import com.example.android_kotlin.di.module.RxThreadModule
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named


class RxThread @Inject constructor(@Named(RxThreadModule.mainThread) private val mainSchedulers: Scheduler,
                                   @Named(RxThreadModule.ioThread) private val ioScheduler: Scheduler) {

    fun <T> applyAsync(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(ioScheduler)
                    .observeOn(mainSchedulers)
        }
    }
}