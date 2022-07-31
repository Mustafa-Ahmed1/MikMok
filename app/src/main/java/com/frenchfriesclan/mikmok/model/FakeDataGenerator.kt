package com.frenchfriesclan.mikmok.model

// TODO: remove this fake class and use the parsed data instead
object FakeDataGenerator {
    private val listOfUrls = listOf(
        "https://android-tv-classics.firebaseapp.com/content/frankenstein_1910/media_frankenstein_1910.mp4",
        "https://android-tv-classics.firebaseapp.com/content/patchwork_girl_oz/media_patchwork_girl_oz.mp4",
        "https://android-tv-classics.firebaseapp.com/content/20000_leagues_under_sea/media_20000_leagues_under_sea.mp4",
        "https://android-tv-classics.firebaseapp.com/content/jazzed_honeymoon/media_jazzed_honeymoon.mp4",
    )

    fun getVideo() = listOfUrls[(0..3).random()]
}