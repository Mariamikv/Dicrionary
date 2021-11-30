package com.example.dictionary.models


import com.google.gson.annotations.SerializedName

data class Phonetic(
    @SerializedName("audio")
    val audio: String?,
    @SerializedName("text")
    val text: String?
)