package com.frenchfriesclan.mikmok.util.extension

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Int.toTimeForm(): String {
    val hours = this / 3600
    val minutes = (this % 3600) / 60
    val seconds = this % 60

    return if(this >= 3600) String.format("%02d:%02d:%02d", hours, minutes, seconds)
    else String.format("%02d:%02d", minutes, seconds)
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}
fun ImageView.loadImageUrl(url:String){
    Glide.with(this.context).load(url).into(this)
}
