package com.githukudenis.testingincompose

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.performClick
import com.githukudenis.testingincompose.ui.theme.TestingInComposeTheme
import com.githukudenis.testingincompose.views.home.HomeScreen
import org.junit.Rule

import org.junit.Test

class HomeScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun homeScreen() {
        composeRule.setContent {
            TestingInComposeTheme {
                HomeScreen(onOpenItem = {})
            }
        }
        composeRule.onAllNodesWithContentDescription("Version card")[0].performClick()
    }
}