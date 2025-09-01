package com.chazal.fdj.search.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.chazal.fdj.search.presentation.composable.SearchError
import com.chazal.fdj.search.presentation.composable.SearchLoading
import com.chazal.fdj.search.presentation.composable.SearchSuccess

@Composable
fun SearchScreen(
    action: SearchAction,
    state: State<SearchState>,
) {
    when (val res = state.value) {
        is SearchState.Error -> SearchError()
        SearchState.Loading -> SearchLoading()
        is SearchState.Success -> SearchSuccess()
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        action = SearchAction({}),
        state = remember { mutableStateOf(SearchState.Loading) }
    )
}
