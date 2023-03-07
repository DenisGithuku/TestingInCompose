package com.githukudenis.testingincompose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

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
            arguments = listOf(navArgument(name = "versionId") {
                type = NavType.LongType
            })
        ) { navBackStackEntry ->
            val versionId = navBackStackEntry.arguments?.getLong("versionId") ?: return@composable
            VersionDetails(versionId = versionId)
        }
    }
}