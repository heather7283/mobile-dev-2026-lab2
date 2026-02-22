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
        Artwork(
            imageRes = R.drawable.artwork2,
            titleRes = R.string.artwork2_title,
            authorRes = R.string.artwork2_artist,
            year = 1665,
        ),
        Artwork(
            imageRes = R.drawable.artwork3,
            titleRes = R.string.artwork3_title,
            authorRes = R.string.artwork3_artist,
            year = 1872,
        ),
        Artwork(
            imageRes = R.drawable.artwork4,
            titleRes = R.string.artwork4_title,
            authorRes = R.string.artwork4_artist,
            year = 1818,
        ),
        Artwork(
            imageRes = R.drawable.artwork5,
            titleRes = R.string.artwork5_title,
            authorRes = R.string.artwork5_artist,
            year = 1887,
        ),
    )

    fun getArtworkCount(): Int = artworks.size
    fun getArtworkAt(index: Int) = artworks[index]
}
