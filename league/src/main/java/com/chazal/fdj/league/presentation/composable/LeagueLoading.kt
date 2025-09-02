package com.chazal.fdj.league.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chazal.fdj.designsystem.components.util.shimmerEffect

@Composable
fun LeagueLoading() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        for (i in 1..3) {
            Row(modifier = Modifier) {
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .size(100.dp)
                        .clip(RectangleShape)
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .size(100.dp)
                        .clip(RectangleShape)
                        .shimmerEffect()
                )
            }
        }
    }
}

@Preview
@Composable
fun LeagueLoadingPreview() {
    LeagueLoading()
}