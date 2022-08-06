package com.frenchfriesclan.mikmok.model.response

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("id") val name: String?,
    @SerializedName("year") val year: Int?,
    @SerializedName("ratings") val ratings: List<String>?,
    @SerializedName("duration") val durationInSeconds: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("director") val director: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("art") val poster: String?,
)