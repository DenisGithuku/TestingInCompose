package com.githukudenis.testingincompose.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(modifier = modifier.fillMaxWidth(.9f), shape = RoundedCornerShape(12.dp)) {
            Column(
                modifier = modifier
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Testing In Compose",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = "In production. Further updates coming in..." +
                            "This app strives to showcase how UI testing is done in compose" +
                            "all from ui components to navigation.",
                    style = TextStyle(
                        textAlign = TextAlign.Justify
                    )
                )
                Spacer(modifier = modifier.height(20.dp))
                Button(onClick = {
                    val gitUrl = "https://github.com/DenisGithuku"
                    Intent(Intent.ACTION_VIEW, Uri.parse(gitUrl)).apply {
                        context.startActivity(this)
                    }
                }) {
                    Text(
                        text = "Other apps"
                    )
                }
            }
        }
    }
}