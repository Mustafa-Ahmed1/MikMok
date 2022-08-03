package com.frenchfriesclan.mikmok.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun Int.toTimeForm(): String {
    var hours = this / 3600;
    var minutes = (this % 3600) / 60;
    var seconds = this % 60;
    var timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    return timeString
}

fun ImageView.loadImageUrl(url:String){
    Glide.with(this.context).load(url).into(this)
}
