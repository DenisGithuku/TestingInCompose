package com.githukudenis.testingincompose

import androidx.compose.ui.test.junit4.createComposeRule
import com.githukudenis.testingincompose.ui.theme.TestingInComposeTheme
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class VersionDetailsKtTest {
    
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun versionDetails() {
        composeRule.setContent { 
            TestingInComposeTheme {
                VersionDetails(versionId = 0L)
            }
        }
    }
}