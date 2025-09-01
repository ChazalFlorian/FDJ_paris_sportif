package com.chazal.fdj.search.presentation.composable

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chazal.fdj.search.domain.model.SearchUI
import com.chazal.fdj.search.presentation.SearchAction
import com.chazal.fdj.search.presentation.SearchState
import com.chazal.fdj.search.presentation.composable.components.SearchItem

@Composable
fun SearchSuccess(
    action: SearchAction,
    state: SearchState.Success,
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        itemsIndexed(state.content.items) { key, item ->
            SearchItem(
                search = item,
                isEven = key % 2 == 0,
                onItemClick = { action.onLeagueClick(item.id) })
        }
    }
}

@Preview
@Composable
fun SearchSuccessPreview() {
    SearchSuccess(
        action = SearchAction({}, {}),
        state = SearchState.Success(SearchUI(listOf()))
    )
}
