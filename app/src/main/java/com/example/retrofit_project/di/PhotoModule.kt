package com.example.retrofit_project.di

import com.example.retrofit_project.api.PhotoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotoModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun providePhotoApi(builder: Retrofit.Builder) : PhotoApi {
        return builder
            .build()
            .create(PhotoApi::class.java)
    }
}