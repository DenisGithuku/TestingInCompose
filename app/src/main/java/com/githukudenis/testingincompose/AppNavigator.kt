package com.githukudenis.testingincompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.githukudenis.testingincompose.views.details.VersionDetails
import com.githukudenis.testingincompose.views.home.HomeScreen

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
            HomeScreen(onOpenItem =  { id ->
                navController.navigate("details/$id")
            })
        }
        composable(
            route = "details/{versionId}",
            arguments = listOf(
                navArgument(name = "versionId") {
                    type = NavType.LongType
                }
            )
        ) {
            VersionDetails()
        }
    }
}