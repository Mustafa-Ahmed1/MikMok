package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.network.ApiService
import com.frenchfriesclan.mikmok.model.network.Client
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video

class DataManagerImpl : DataManager, ApiService {
    val videoFeeds: MutableList<Feed>
        get() = Client.videoFeeds

    override fun getFeedsMap(): Map<Video, Feed> {
        val feedsMap = mutableMapOf<Video, Feed>()
        videoFeeds.forEach { feed ->
            feed.videos?.forEach { video ->
                feedsMap[video] = feed
            }
        }
        return feedsMap
    }

    override fun requestVideoFeed(setResponseState: (isSuccess: Boolean) -> Unit) {
        Client.requestVideoFeed(setResponseState)
    }

}