package com.example.dictionary.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dictionary.api.request.ApiService
import com.example.dictionary.models.Words
import com.example.dictionary.utils.Result

class DictionaryRepository (private val apiService: ApiService) {
    suspend fun getWordsList(word: String): MutableLiveData<List<Words>> {
        val wordsLiveData = MutableLiveData<List<Words>>().apply {
            mutableListOf<Words>()
        }
        val _wordsLiveData: LiveData<List<Words>> = wordsLiveData

        val response = apiService.wordsList(word)
        if(response.isSuccessful){
            val items = response.body()
            wordsLiveData.postValue(items)
        }
        return wordsLiveData
    }
}