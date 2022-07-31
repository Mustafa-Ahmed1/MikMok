package com.frenchfriesclan.mikmok.model.domain

data class Video(
    val id: String,
    val year: Int,
    val ratings: List<String>?,
    val duration: Int,
    val title: String,
    val director: String,
    val description: String,
    val url: String,
    val art: String
)