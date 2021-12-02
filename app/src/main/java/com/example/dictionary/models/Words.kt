package com.example.dictionary.models


import com.google.gson.annotations.SerializedName

data class Words(
    @SerializedName("meanings")
    val meanings: List<Meaning>?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("phonetic")
    val phonetic: String?,
    @SerializedName("phonetics")
    val phonetics: List<Phonetic>?,
    @SerializedName("word")
    val word: String?
)