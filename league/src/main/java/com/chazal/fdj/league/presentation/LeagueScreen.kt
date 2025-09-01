package com.chazal.fdj.league.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.chazal.fdj.league.presentation.composable.LeagueError
import com.chazal.fdj.league.presentation.composable.LeagueLoading
import com.chazal.fdj.league.presentation.composable.LeagueSuccess

@Composable
fun LeagueScreen(
    state: State<LeagueScreenState>,
) {
    when (val res = state.value) {
        is LeagueScreenState.Error -> LeagueError()
        LeagueScreenState.Loading -> LeagueLoading()
        is LeagueScreenState.Success -> LeagueSuccess(
            state = res
        )
    }
}

@Preview
@Composable
fun LeagueScreenPreview() {
    LeagueScreen(
        state = remember { mutableStateOf(LeagueScreenState.Loading) },
    )
}
