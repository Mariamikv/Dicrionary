package com.example.dictionary.api.request

import com.example.dictionary.models.Words
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("en/{word}")
    suspend fun wordsList(@Path("word") word: String): Response<List<Words>>
}