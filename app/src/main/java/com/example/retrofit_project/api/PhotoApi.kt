package com.example.retrofit_project.api

import retrofit2.http.GET

interface PhotoApi {

    @GET("breeds/image/random")
    suspend fun getPhoto(): Photo

}