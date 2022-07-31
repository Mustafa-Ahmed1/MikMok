package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.domain.APIResponse
import com.frenchfriesclan.mikmok.model.domain.Feed

class DataManger {
    private var apiResponse: APIResponse? = null

    fun setAPIResponse(sendAPIResponse: APIResponse){
        apiResponse = sendAPIResponse
    }

    fun getFeeds(): List<Feed> {
        return requireNotNull(apiResponse).feed
    }
}