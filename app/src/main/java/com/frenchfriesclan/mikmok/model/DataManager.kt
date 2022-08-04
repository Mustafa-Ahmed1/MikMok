package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video


interface DataManager {
    fun getFeedsMap(): Map<Video, Feed>
}