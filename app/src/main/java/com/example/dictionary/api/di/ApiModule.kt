package com.example.dictionary.api.di

import com.example.dictionary.api.request.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(ApiService::class.java)
    }
}