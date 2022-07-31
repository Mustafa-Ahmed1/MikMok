package com.frenchfriesclan.mikmok.ui.player

import android.util.Log
import com.frenchfriesclan.mikmok.databinding.ActivityPlayerBinding
import com.frenchfriesclan.mikmok.model.FakeDataGenerator
import com.frenchfriesclan.mikmok.ui.base.BaseActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class PlayerActivity : BaseActivity<ActivityPlayerBinding>() {
    var player : ExoPlayer? = null
    private var playWhenReady = true
    private var currentItem = 0
    private var playbackPosition = 0L
    val currentVideo = FakeDataGenerator.getVideo() // TODO: get real data instead of this fake data generator

    override fun bindingInflater() = ActivityPlayerBinding.inflate(layoutInflater)

    override fun onStart() {
        super.onStart()
        Log.i("PLAYER_ACTIVITY","STARTED!")
        initializePlayer()
    }


    private fun initializePlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                binding.videoView.player = exoPlayer
                val mediaItem = MediaItem.fromUri(currentVideo)
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentItem, playbackPosition)
                exoPlayer.prepare()
            }
    }


    override fun onStop() {
        super.onStop()
        Log.i("PLAYER_ACTIVITY","STOPPED!")
        releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        Log.i("PLAYER_ACTIVITY","PAUSED!")
        releasePlayer()
    }

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            Log.i("PLAYER_ACTIVITY", "current position: ${exoPlayer.currentPosition} , current media item index : ${exoPlayer.currentMediaItemIndex}, play when ready : ${exoPlayer.playWhenReady}")
            playbackPosition = exoPlayer.currentPosition
            currentItem = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }

}