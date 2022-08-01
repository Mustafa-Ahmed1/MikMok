package com.frenchfriesclan.mikmok.model.response

import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("id") val category: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("image") val categoryImage: String?,
    @SerializedName("items") val videos: List<Video>?
)
