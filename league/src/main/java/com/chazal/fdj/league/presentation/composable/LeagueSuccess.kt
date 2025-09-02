package com.chazal.fdj.league.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.chazal.fdj.league.domain.model.LeagueItemBlockUI
import com.chazal.fdj.league.domain.model.LeagueUI
import com.chazal.fdj.league.presentation.LeagueScreenState

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LeagueSuccess(
    state: LeagueScreenState.Success
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(state.content.content) { team ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    model = team.logoUrl,
                    contentDescription = team.description,
                    modifier = Modifier
                        .fillMaxWidth(),
                    loading = placeholder { CircularProgressIndicator() }
                )
            }
        }
    }
}

@Preview
@Composable
fun LeagueSuccessPreview() {
    LeagueSuccess(
        state = LeagueScreenState.Success(
            content = LeagueUI(
                content = listOf(
                    LeagueItemBlockUI(
                        logoUrl = "adada",
                        description = "aad"
                    ),
                    LeagueItemBlockUI(
                        logoUrl = "lolo",
                        description = "aab"
                    )
                )
            )
        )
    )
}