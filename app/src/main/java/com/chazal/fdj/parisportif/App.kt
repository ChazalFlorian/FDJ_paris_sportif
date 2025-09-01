package com.chazal.fdj.parisportif

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chazal.fdj.parisportif.Routes.Search
import com.chazal.fdj.parisportif.splash.presentation.SplashScreen
import com.chazal.fdj.parisportif.ui.theme.FDJTheme
import com.chazal.fdj.search.presentation.SearchAction
import com.chazal.fdj.search.presentation.SearchScreen
import com.chazal.fdj.search.presentation.SearchViewModel
import org.koin.java.KoinJavaComponent.inject

@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    FDJTheme {
        NavHost(
            navController = navController,
            startDestination = Routes.Splash,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<Routes.Splash> {
                SplashScreen(
                    goToNext = {
                        navController.navigate(Search)
                    }
                )
            }
            composable<Search> {
                val vm: SearchViewModel by inject(SearchViewModel::class.java)
                SearchScreen(
                    action = SearchAction(
                        search = vm::searchInput
                    ),
                    state = vm.uiState.collectAsState()
                )
            }
        }
    }
}