package com.example.dictionary.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dictionary.api.request.ApiService
import com.example.dictionary.models.Words
import com.example.dictionary.ui.SearchScreenFragment
import com.example.dictionary.utils.Result

class DictionaryRepository (private val apiService: ApiService) {
//    suspend fun getWordsList() = SearchScreenFragment.WORD.let {
//        if (it != null) {
//            apiService.wordsList(it)
//        }
//    }

    suspend fun getWordsList(): MutableLiveData<List<Words>> {
        val wordsLiveData = MutableLiveData<List<Words>>().apply {
            mutableListOf<Words>()
        }
        val _wordsLiveData: LiveData<List<Words>> = wordsLiveData

        val response = SearchScreenFragment.WORD?.let { apiService.wordsList(it) }

        if (response != null) {
            if(response.isSuccess){
                Result.Success(response)
            }else{
                val errorMsg = response.isFailure.toString()
                Result.Error(errorMsg)
            }
        }
        return wordsLiveData
    }
}