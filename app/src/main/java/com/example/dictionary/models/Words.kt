package com.example.dictionary.models


import com.google.gson.annotations.SerializedName

data class Words(
    @SerializedName("meanings")
    val meanings: List<Meaning>?,
    @SerializedName("phonetics")
    val phonetics: List<Phonetic>?,
    //val origin: String?,
    //val phonetic: String?,
    @SerializedName("word")
    val word: String?
)