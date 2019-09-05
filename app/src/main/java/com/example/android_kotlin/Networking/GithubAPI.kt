package com.example.android_kotlin.Networking


import com.example.android_kotlin.model.Repo
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("users/{user}/repos")
    fun getRepo(@Path("user") user: String): Observable<List<Repo>>
}
