package com.frenchfriesclan.mikmok.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frenchfriesclan.mikmok.model.domain.Video

class VideoAdapter(private val list: List<Video>): RecyclerView.Adapter<VideoAdapter.BaseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }



    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {

    }

    class VideoViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
//        val binding = ItemVideoBinding.bind(viewItem)
    }


}