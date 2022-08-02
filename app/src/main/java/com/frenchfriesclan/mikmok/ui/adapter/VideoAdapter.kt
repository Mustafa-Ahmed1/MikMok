package com.frenchfriesclan.mikmok.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frenchfriesclan.mikmok.R
import com.frenchfriesclan.mikmok.databinding.VideoItemBinding
import com.frenchfriesclan.mikmok.model.response.Feed
import com.frenchfriesclan.mikmok.model.response.Video
import com.frenchfriesclan.mikmok.util.extension.toTimeForm

class VideoAdapter(private val list: List<Feed>): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideoViewHolder(view)
    }
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentVideo = list[position]
        val currentVideos = list[position].videos!![0]
        holder.binding.apply {
            textCategoryTitle.text = currentVideo.category
            textVideoTitle.text = currentVideos.title
            textVideoDescription.text = currentVideos.description
            textVideoYear.text = currentVideo.videos!![0].year.toString()
            textVideoDirector.text = currentVideos.director
            textVideoDuration.text = currentVideos.durationInSeconds?.toTimeForm()
        }
    }

    override fun getItemCount(): Int = list.size

//    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
//
//    }

     class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        val binding = VideoItemBinding.bind(viewItem)
    }



}