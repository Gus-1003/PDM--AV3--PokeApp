package com.example.terceiraprova.model

import com.google.gson.annotations.SerializedName

data class Pok(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)
