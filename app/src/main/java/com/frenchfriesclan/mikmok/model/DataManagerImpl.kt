package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.network.ApiService
import com.frenchfriesclan.mikmok.model.network.Client
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video

class DataManagerImpl : DataManager, ApiService {
    private val videoFeeds: MutableList<Feed>
        get() = Client.videoFeeds
    private val feedsMap = mutableMapOf<Video, Feed>()

    override fun getFeedsMap(): Map<Video, Feed> {
        mapVideoFeeds()
        return feedsMap
    }

    private fun mapVideoFeeds() {
        videoFeeds.forEach { feed ->
            feed.videos?.forEach { video ->
                feedsMap[video] = feed
            }
        }
    }

    override fun requestVideoFeed(setResponseState: (isSuccess: Boolean) -> Unit) {
        Client.requestVideoFeed(setResponseState)
    }

}