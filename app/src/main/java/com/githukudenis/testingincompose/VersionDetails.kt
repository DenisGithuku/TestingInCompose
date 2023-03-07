package com.githukudenis.testingincompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun VersionDetails(
    modifier: Modifier = Modifier,
    versionId: Long,
) {

    val androidVersionItem = remember {
        androidVersions.find {
            it.id == versionId
        }
    }

    Log.e("id", androidVersionItem?.id.toString())

    val title = androidVersionItem?.title ?: return
    val description = androidVersionItem.description ?: return

    Column(
        modifier = modifier.fillMaxSize(),
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