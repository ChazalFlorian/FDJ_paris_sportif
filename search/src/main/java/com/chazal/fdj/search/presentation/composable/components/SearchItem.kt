package com.chazal.fdj.search.presentation.composable.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chazal.fdj.search.domain.model.SearchItemBlockUI

@Composable
fun SearchItem(
    search: SearchItemBlockUI,
    isEven: Boolean = false,
    onItemClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable {
                onItemClick(search.league)
            }
            .fillMaxWidth()
            .background(
                color = if (isEven) {
                    Color.White
                } else {
                    Color.LightGray
                }
            ),
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp),
            text = search.league
        )
    }
}