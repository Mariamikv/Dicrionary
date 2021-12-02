package com.example.dictionary.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary.api.repository.DictionaryRepository
import com.example.dictionary.models.Words
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(private val dictionaryRepository: DictionaryRepository): ViewModel() {



    var getWords = MutableLiveData<List<Words>>()

    suspend fun getWords(word: String): LiveData<List<Words>> {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getWords = dictionaryRepository.getWordsList(word)
            }
        }
        return getWords
    }
}