package com.frenchfriesclan.mikmok.util.extension

fun Int.toTimeForm(): String {
    var hours = this / 3600;
    var minutes = (this % 3600) / 60;
    var seconds = this % 60;
    var timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    return timeString
}