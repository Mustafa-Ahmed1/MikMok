package com.frenchfriesclan.mikmok.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frenchfriesclan.mikmok.R
import com.frenchfriesclan.mikmok.databinding.ActivityPlayerBinding
import com.frenchfriesclan.mikmok.model.domain.Video

class VideoAdapter(private val list: List<Video>): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_player, parent, false)
        return VideoViewHolder(view)
    }
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size

//    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
//
//    }

     class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        val binding = ActivityPlayerBinding.bind(viewItem)
    }

}