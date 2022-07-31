package com.frenchfriesclan.mikmok.model.domain

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val items: List<Video>
)
