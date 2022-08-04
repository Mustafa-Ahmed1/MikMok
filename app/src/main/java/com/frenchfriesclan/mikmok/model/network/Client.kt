package com.frenchfriesclan.mikmok.model.network

import android.util.Log
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.VideoResponse
import com.frenchfriesclan.mikmok.util.Constant
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object Client {
    private val okHttpClient = OkHttpClient()
    val videoFeeds = mutableListOf<Feed>()


    fun requestVideoFeed(setResponseState :(isSuccess: Boolean) -> Unit) {
        val request = Request.Builder()
            .url(Constant.REQUEST_URL)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.i("CLIENT",e.message.toString())
                setResponseState(false)
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { jsonString ->
                    val jsonResponse = Gson().fromJson(jsonString, VideoResponse::class.java)
                    jsonResponse.feed?.forEach { feed ->
                        videoFeeds.add(feed)
                    }
                }
                setResponseState(true)
            }

        }
        )
    }

}