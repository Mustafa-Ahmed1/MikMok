package com.frenchfriesclan.mikmok.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frenchfriesclan.mikmok.databinding.FragmentHomeBinding
import com.frenchfriesclan.mikmok.model.DataManagerImpl
import com.frenchfriesclan.mikmok.ui.adapter.VideoAdapter
import com.frenchfriesclan.mikmok.ui.adapter.VideoPlayer
import com.frenchfriesclan.mikmok.ui.base.BaseFragment
import com.frenchfriesclan.mikmok.util.extension.hide
import com.frenchfriesclan.mikmok.util.extension.pausePlayer
import com.frenchfriesclan.mikmok.util.extension.resumePlayer
import com.frenchfriesclan.mikmok.util.extension.show

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    private val dataManger = DataManagerImpl()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.error.hide()
        dataManger.requestVideoFeed { isResponseSuccessful ->
            if (isResponseSuccessful) {
                val feeds = dataManger.getFeedsMap()
                activity?.runOnUiThread {
                    binding.recyclerViewVideos.adapter = VideoAdapter(feeds)
                    binding.loading.hide()
                }
            } else {
                activity?.runOnUiThread {
                    binding.loading.hide()
                    binding.error.show()
                }
            }
        }
    }


    override fun onPause() {
        super.onPause()
        Log.d("LIFE_CYCLE", "OnPause")
        VideoPlayer.pausePlayer()
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFE_CYCLE", "OnResume")
        VideoPlayer.resumePlayer()
    }

    override fun onDetach() {
        super.onDetach()
        VideoPlayer.stopPlayer()
        Log.d("LIFE_CYCLE", "onDetach")
    }
}