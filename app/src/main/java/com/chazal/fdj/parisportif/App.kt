package com.chazal.fdj.parisportif

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chazal.fdj.parisportif.ui.theme.FDJTheme

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    FDJTheme {
        NavHost(
            navController = navController,
            startDestination = Routes.Splash,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<Routes.Splash> {

            }
        }
    }
}