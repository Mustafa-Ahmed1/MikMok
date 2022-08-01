package com.frenchfriesclan.mikmok.model

import com.frenchfriesclan.mikmok.model.response.Feed


interface DataManager {
    fun requestVideoFeed(onSuccess: (isSuccess: Boolean) -> Unit)
}