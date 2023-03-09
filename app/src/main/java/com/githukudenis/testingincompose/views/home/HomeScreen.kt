package com.githukudenis.testingincompose.views.home

import android.content.res.Configuration
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOpenItem: (Long) -> Unit
) {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val state = homeViewModel.state.value

    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .semantics {
                contentDescription = "Version list"
            },
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
            items = state.versions,
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
                    .clip(RoundedCornerShape(20.dp))
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

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun HomeScreenPreview() {
    HomeScreen {

    }
}