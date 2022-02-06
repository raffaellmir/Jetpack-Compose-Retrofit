package com.example.retrofit_project.api

import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName("message")
    val url : String,
    @SerializedName("status")
    val status: String
)