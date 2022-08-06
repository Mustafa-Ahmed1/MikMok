package com.frenchfriesclan.mikmok.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frenchfriesclan.mikmok.R
import com.frenchfriesclan.mikmok.databinding.ItemVideoBinding
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video
import com.frenchfriesclan.mikmok.util.extension.loadImageUrl
import com.frenchfriesclan.mikmok.util.extension.releasePlayer
import com.frenchfriesclan.mikmok.util.extension.toTimeForm

class VideoAdapter(private var videosMap: Map<Video, Feed>) :
    RecyclerView.Adapter<VideoViewHolder>() {
    private val videosList = videosMap.keys.toList().shuffled()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentVideo = videosList[position]
        val currentFeed = videosMap.getValue(currentVideo)

        holder.binding.apply {
            textCategoryTitle.text = currentFeed.category
            textVideoTitle.text = currentVideo.title
            textVideoDescription.text = currentVideo.description
            textVideoYear.text = currentVideo.year.toString()
            textVideoDirector.text = currentVideo.director
            textVideoDuration.text = currentVideo.durationInSeconds?.toTimeForm()
            imageCategory.loadImageUrl(currentFeed.categoryImage.toString())
            imageVideoBackground.loadImageUrl(currentVideo.poster.toString())


            imageVideoBackground.addOnAttachStateChangeListener(object :
                View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(p0: View?) {
                    VideoPlayer.releasePlayer()
                    p0?.context?.let { context ->
                        VideoPlayer.initializePlayer(
                            holder,
                            context,
                            currentVideo.url.toString()
                        )
                    }
                    Log.d("ATTACH_BEHAVIOUR", "${p0?.context} attached")

                }

                override fun onViewDetachedFromWindow(p0: View?) {
                    Log.d("ATTACH_BEHAVIOUR", "${p0?.context} detached")
                }

            })


        }
    }

    override fun getItemCount(): Int = videosMap.size

}


class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val binding = ItemVideoBinding.bind(viewItem)
}
