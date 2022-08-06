package com.frenchfriesclan.mikmok.ui.adapter

import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player

object VideoPlayer {
    var exoPlayer: ExoPlayer? = null
    private var playWhenReady = true
    private var currentItem = 0
    private var playbackPosition = 0L

    fun initializePlayer(
        holder: VideoViewHolder,
        context: Context,
        currentVideoUrl: String
    ) {
        exoPlayer = ExoPlayer.Builder(context)
            .build()
            .also { exoPlayer ->
                holder.binding.videoView.player = exoPlayer
                val mediaItem = MediaItem.fromUri(currentVideoUrl)
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentItem, playbackPosition)
                exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                exoPlayer.prepare()
                exoPlayer.play()
            }
        Log.i("VIDEO_PLAYER", "now playing ${holder.binding.textVideoTitle.text.toString()}")
    }

    fun stopPlayer() {
        exoPlayer?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            currentItem = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.stop()
        }
    }
}