package com.chazal.fdj.parisportif

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chazal.fdj.designsystem.theme.FDJTheme
import com.chazal.fdj.league.presentation.LeagueScreen
import com.chazal.fdj.league.presentation.LeagueViewModel
import com.chazal.fdj.parisportif.Routes.Search
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
            startDestination = Search,
            modifier = Modifier.fillMaxSize().background(color = Color.LightGray)
        ) {
            composable<Search> {
                val vm: SearchViewModel by inject(SearchViewModel::class.java)
                SearchScreen(
                    action = SearchAction(
                        search = vm::filterSearchResults,
                        onLeagueClick = { id ->
                            navController.navigate(Routes.League(source = id))
                        },
                    ),
                    state = vm.uiState.collectAsState()
                )
            }
            composable<Routes.League> { backStackEntry ->
                val source: String = backStackEntry.arguments?.get("source") as String
                val vm: LeagueViewModel by inject(LeagueViewModel::class.java)
                vm.getLeagues(source)
                LeagueScreen(
                    state = vm.uiState.collectAsState(),
                )
            }
        }
    }
}