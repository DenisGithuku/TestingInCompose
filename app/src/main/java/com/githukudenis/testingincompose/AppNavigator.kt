package com.githukudenis.testingincompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigator(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "splash") {
        composable(route = "splash") {
            SplashScreen {
                navController.navigate("home") {
                    popUpTo("splash") {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = "home") {
            HomeScreen {

            }
        }
    }
}