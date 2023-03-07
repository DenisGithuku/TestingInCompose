package com.githukudenis.testingincompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.githukudenis.testingincompose.ui.theme.TestingInComposeTheme
import org.junit.Rule
import org.junit.Test

class SplashScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun splashScreen() {
        composeRule.setContent {
            TestingInComposeTheme {
                SplashScreen {

                }
            }
        }
        composeRule.onNodeWithText("Composer").assertIsDisplayed()
    }
}