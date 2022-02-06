package com.example.retrofit_project.repository

import com.example.retrofit_project.api.Photo
import com.example.retrofit_project.api.PhotoApi
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val photoApi : PhotoApi) {

    suspend fun getPhoto() : Photo = photoApi.getPhoto()
}