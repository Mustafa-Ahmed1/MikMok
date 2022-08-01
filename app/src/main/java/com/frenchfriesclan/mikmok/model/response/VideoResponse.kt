package com.frenchfriesclan.mikmok.model.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("feed") val feed: List<Feed>?,
    @SerializedName("backgrounds") val backgrounds: List<String>?,
)