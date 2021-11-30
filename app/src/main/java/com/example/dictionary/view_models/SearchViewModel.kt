package com.example.dictionary.view_models

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

    fun init(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getWords()
            }
        }
    }

     suspend fun getWords(): LiveData<List<Words>> {
        return dictionaryRepository.getWordsList()
    }
}