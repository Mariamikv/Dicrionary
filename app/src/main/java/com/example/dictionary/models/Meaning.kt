package com.example.dictionary.models


import com.google.gson.annotations.SerializedName

data class Meaning(
    @SerializedName("definitions")
    val definitions: List<Definition>?,
    @SerializedName("partOfSpeech")
    val partOfSpeech: String?
)