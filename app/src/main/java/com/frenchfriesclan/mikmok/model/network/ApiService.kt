package com.frenchfriesclan.mikmok.model.network

interface ApiService {
    fun requestVideoFeed(setResponseState: (isSuccess: Boolean) -> Unit)
}