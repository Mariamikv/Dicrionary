package com.example.dictionary.api.di

import com.example.dictionary.view_models.SearchViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
}