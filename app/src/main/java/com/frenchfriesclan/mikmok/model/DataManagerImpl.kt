package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.network.Client
import com.frenchfriesclan.mikmok.model.response.Feed

class DataManagerImpl : DataManager {


    fun getFeeds(): MutableList<Feed> {
        return Client.videoFeeds
    }

    override fun requestVideoFeed(onSuccess: (isSuccess: Boolean) -> Unit)  {
         Client.requestVideoFeed(onSuccess)
    }

}