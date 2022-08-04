package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.network.Client
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video

class DataManagerImpl : DataManager {
    val videoFeeds: MutableList<Feed>
        get() = Client.videoFeeds

    fun getFeedsMap(): Map<Video, Feed> {
        val feedsMap = mutableMapOf<Video, Feed>()
        videoFeeds.forEach { feed ->
            feed.videos?.forEach { video ->
                feedsMap[video] = feed
            }
        }
        return feedsMap
    }

    override fun requestVideoFeed(onSuccess: (isSuccess: Boolean) -> Unit) {
        Client.requestVideoFeed(onSuccess)
    }

}