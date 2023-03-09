package com.githukudenis.testingincompose.views.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun VersionDetails(
    modifier: Modifier = Modifier,
) {

    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val state = detailsViewModel.state.value

    val title = state.title ?: return
    val description = state.description ?: return

    Column(
        modifier = modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title
        )
        Text(
            text = description
        )
    }
}