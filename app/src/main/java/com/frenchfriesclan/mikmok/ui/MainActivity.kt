package com.frenchfriesclan.mikmok.ui

import android.os.Bundle
import android.view.View
import com.frenchfriesclan.mikmok.databinding.ActivityMainBinding
import com.frenchfriesclan.mikmok.model.DataManagerImpl
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video
import com.frenchfriesclan.mikmok.ui.adapter.VideoAdapter
import com.frenchfriesclan.mikmok.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    private val dataManger = DataManagerImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.error.visibility = View.GONE
        dataManger.requestVideoFeed() { isResponseSuccessful ->
            if (isResponseSuccessful) {
                setAdapter(dataManger.getFeedsMap())
            } else {
                setAdapter(emptyMap())
                runOnUiThread {
                    binding.error.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setAdapter(feeds: Map<Video, Feed>) {
        val adapter = VideoAdapter(feeds)
        runOnUiThread {
            binding.loading.visibility = View.GONE
            binding.recyclerViewVideos.adapter = adapter
        }
    }
}
