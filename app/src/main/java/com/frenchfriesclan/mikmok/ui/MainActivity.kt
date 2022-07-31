package com.frenchfriesclan.mikmok.ui

import android.util.Log
import com.frenchfriesclan.mikmok.databinding.ActivityMainBinding
import com.frenchfriesclan.mikmok.model.DataManger
import com.frenchfriesclan.mikmok.model.domain.APIResponse
import com.frenchfriesclan.mikmok.ui.base.BaseActivity
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val client = OkHttpClient()
    private val dataManger = DataManger()

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    override fun onStart() {
        super.onStart()
        makeRequestUsingOkhttp()
    }

    private fun makeRequestUsingOkhttp(){
        val request = Request.Builder()
            .url("https://raw.githubusercontent.com/android/tv-samples/main/ClassicsKotlin/app/src/main/assets/media-feed.json")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.v("AWE", "error")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { jsonString ->
                    val result = Gson().fromJson(jsonString, APIResponse::class.java)
                    dataManger.setAPIResponse(result)
                }
            }

        })
    }

}