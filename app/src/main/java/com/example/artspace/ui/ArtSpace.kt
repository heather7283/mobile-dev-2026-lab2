package com.example.artspace.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.R
import com.example.artspace.data.Artwork
import com.example.artspace.data.ArtworkList

val artworkList = ArtworkList()

@Composable
fun ArtSpace() {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    ArtSpaceTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val padding = dimensionResource(R.dimen.edges_padding)

            if (isLandscape) {
                LandscapeLayout(Modifier.safeContentPadding().padding(padding))
            } else {
                PortraitLayout(Modifier.safeContentPadding().padding(padding))
            }
        }
    }
}

@Composable
fun PortraitLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        val artwork = artworkList.getArtworkAt(0)
        ArtworkImage(artwork)
        Spacer(Modifier.size(dimensionResource(R.dimen.spacing)))
        ArtworkInfo(artwork)
    }
}

@Composable
fun LandscapeLayout(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        val artwork = artworkList.getArtworkAt(0)
        ArtworkImage(artwork)
        Spacer(Modifier.size(dimensionResource(R.dimen.spacing)))
        ArtworkInfo(artwork)
    }
}

@Composable
fun ArtworkImage(artwork: Artwork, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onBackground,
    ) {
        Image(
            painter = painterResource(artwork.imageRes),
            contentDescription = stringResource(artwork.titleRes),
        )
    }
}

@Composable
fun ArtworkInfo(artwork: Artwork, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Title
        Text(
            text = stringResource(artwork.titleRes),
            fontSize = dimensionResource(R.dimen.title_font_size).value.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )
        // Author
        Text(
            text = stringResource(artwork.authorRes),
            fontSize = dimensionResource(R.dimen.author_font_size).value.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
        )
        // Year
        Text(
            text = artwork.year.toString(),
            fontSize = dimensionResource(R.dimen.year_font_size).value.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary,
        )
    }
}
