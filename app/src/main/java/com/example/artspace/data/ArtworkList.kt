package com.example.artspace.data

import com.example.artspace.R

class ArtworkList {
    private val artworks = listOf(
        Artwork(
            imageRes = R.drawable.artwork1,
            titleRes = R.string.artwork1_title,
            authorRes = R.string.artwork1_artist,
            year = 1831,
        ),
    )

    fun getArtworkCount(): Int = artworks.size
    fun getArtworkAt(index: Int) = artworks[index]
}
