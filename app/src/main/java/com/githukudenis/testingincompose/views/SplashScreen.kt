package com.githukudenis.testingincompose

import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalTextApi::class)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit
) {
    val animateText = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = Unit) {
        animateText.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = EaseIn
            )
        )
        delay(1000)
        onNavigateToHome()
    }

    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildString {
                with(LocalTextStyle.current) {
                    append("Com")
                }
                append("poser")
            },
            style = TextStyle(
                fontSize = 40.sp * animateText.value,
                brush = Brush.horizontalGradient(colors = listOf(Color.Red, Color.Magenta)),
                fontWeight = FontWeight.Bold

            ),
            modifier = modifier.graphicsLayer {
                rotationX *= animateText.value
            }
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen {

    }
}