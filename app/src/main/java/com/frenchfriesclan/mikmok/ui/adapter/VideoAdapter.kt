package com.frenchfriesclan.mikmok.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frenchfriesclan.mikmok.R
import com.frenchfriesclan.mikmok.databinding.ItemVideoBinding
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video
import com.frenchfriesclan.mikmok.util.extension.loadImageUrl
import com.frenchfriesclan.mikmok.util.extension.toTimeForm

class VideoAdapter(private var list: Map<Video,Feed>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    val videoPlayer = VideoPlayer()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentVideo = list.keys.toList()[position]
        val currentFeed = list.getValue(currentVideo)
        holder.binding.apply {
            textCategoryTitle.text = currentFeed.category
            textVideoTitle.text = currentVideo.title
            textVideoDescription.text = currentVideo.description
            textVideoYear.text = currentVideo.year.toString()
            textVideoDirector.text = currentVideo.director
            textVideoDuration.text = currentVideo.durationInSeconds?.toTimeForm()
            imageCategory.loadImageUrl(currentFeed.categoryImage.toString())
            imageVideoBackground.loadImageUrl(currentVideo.poster.toString())
            videoPlayer.initializePlayer(holder,currentVideo.videoUrl.toString())
        }
    }

    override fun getItemCount(): Int = list.size

    class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemVideoBinding.bind(viewItem)
    }

}