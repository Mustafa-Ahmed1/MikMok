package com.frenchfriesclan.mikmok.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frenchfriesclan.mikmok.databinding.FragmentHomeBinding
import com.frenchfriesclan.mikmok.model.DataManagerImpl
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video
import com.frenchfriesclan.mikmok.ui.adapter.VideoAdapter
import com.frenchfriesclan.mikmok.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    private val dataManger = DataManagerImpl()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.error.visibility = View.GONE
        dataManger.requestVideoFeed() { isResponseSuccessful ->
            if (isResponseSuccessful) {
                setAdapter(dataManger.getFeedsMap())
            } else {
                setAdapter(emptyMap())
                activity?.runOnUiThread {
                    binding.error.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setAdapter(feeds: Map<Video, Feed>) {
        val adapter = VideoAdapter(feeds)
        activity?.runOnUiThread {
            binding.loading.visibility = View.GONE
            binding.recyclerViewVideos.adapter = adapter
        }
    }
}