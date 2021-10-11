package com.dreamer.newsonjetpack.provider

import com.dreamer.newsonjetpack.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//private const val API_KEY = "fe050c83e88a4c9d93e6bff7842a1da1"
private const val API_KEY = "f98a6d49d8ce4c75a0d336126c1562ab"

interface NewsProvider {

    @GET("top-headlines?apiKey=$API_KEY")
    suspend fun topHeadLines(@Query("country") country: String): Response<NewsApiResponse>
}