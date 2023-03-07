package com.githukudenis.testingincompose

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOpenItem: (Long) -> Unit
) {


    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Android versions"
                    )
                }
            )
        }
        items(
            items = androidVersions,
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .semantics {
                        contentDescription = "Version card"
                    }
                    .clickable { onOpenItem(it.id) }
                    .padding(16.dp)
                    .animateItemPlacement(
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = EaseIn
                        )
                    ),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(modifier = modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(color = Color.LightGray)
                    .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = it.id.toString(),
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = it.title ?: return@Column
                    )
                    Text(
                        text = it.description ?: return@Column
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen {

    }
}