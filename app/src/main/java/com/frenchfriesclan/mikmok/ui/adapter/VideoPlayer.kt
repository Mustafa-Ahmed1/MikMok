package com.frenchfriesclan.mikmok.ui.adapter

import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

object VideoPlayer  {
    var exoPlayer : ExoPlayer? = null
    private var playWhenReady = true
    private var currentItem = 0
    private var playbackPosition = 0L

    fun initializePlayer(holder: VideoAdapter.VideoViewHolder, currentVideoUrl: String) {
        exoPlayer = ExoPlayer.Builder(holder.binding.root.context)
            .build()
            .also { exoPlayer ->
                holder.binding.videoView.player = exoPlayer
                val mediaItem = MediaItem.fromUri(currentVideoUrl)
                VideoPlayer.exoPlayer?.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentItem, playbackPosition)
                exoPlayer.prepare()
            }
    }


     fun releasePlayer() {

        exoPlayer?.let { exoPlayer ->
            Log.i("PLAYER_ACTIVITY", "current position: ${exoPlayer.currentPosition} , current media item index : ${exoPlayer.currentMediaItemIndex}, play when ready : ${exoPlayer.playWhenReady}")
            playbackPosition = exoPlayer.currentPosition
            currentItem = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        exoPlayer = null
    }

}