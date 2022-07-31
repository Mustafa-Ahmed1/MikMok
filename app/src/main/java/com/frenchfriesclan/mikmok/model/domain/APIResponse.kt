package com.frenchfriesclan.mikmok.model.domain

data class APIResponse(
    val feed: List<Feed>,
    val backgrounds: List<String>
)