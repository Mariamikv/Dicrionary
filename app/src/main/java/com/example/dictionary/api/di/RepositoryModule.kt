package com.example.dictionary.api.di

import com.example.dictionary.api.repository.DictionaryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DictionaryRepository(get()) }
}