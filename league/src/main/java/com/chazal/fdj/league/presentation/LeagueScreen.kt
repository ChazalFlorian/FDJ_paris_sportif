package com.chazal.fdj.league.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.chazal.fdj.league.domain.model.LeagueUI
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
fun LeagueScreenPreview(
    @PreviewParameter(LeagueScreenStateParameter::class) state: LeagueScreenState,
) {
    LeagueScreen(
        state = remember { mutableStateOf(state) },
    )
}

private class LeagueScreenStateParameter : PreviewParameterProvider<LeagueScreenState> {
    override val values: Sequence<LeagueScreenState>
        get() = listOf(
            LeagueScreenState.Loading,
            LeagueScreenState.Error("No Network Available !"),
            LeagueScreenState.Success(
                content = LeagueUI(
                    content = listOf()
                )
            )
        ).asSequence()
}