package com.chazal.fdj.search.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chazal.fdj.search.presentation.composable.SearchError
import com.chazal.fdj.search.presentation.composable.SearchLoading
import com.chazal.fdj.search.presentation.composable.SearchSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    action: SearchAction,
    state: State<SearchState>,
) {
    val query = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            SearchBar(
                query = query.value,
                onQueryChange = {
                    query.value = it
                    CoroutineScope(Dispatchers.Main).launch {
                        action.search(it)
                    }
                },
                onSearch = {
                    query.value = it
                    CoroutineScope(Dispatchers.IO).launch {
                        action.search(it)
                    }
                },
                active = true,
                onActiveChange = {},
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
            ) {

            }
        },
        content = { paddings ->
            Column(
                modifier = Modifier.padding(paddings)
            ) {
                when (val res = state.value) {
                    is SearchState.Error -> SearchError()
                    SearchState.Loading -> SearchLoading()
                    is SearchState.Success -> SearchSuccess(
                        action = action, state = res
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        action = SearchAction({}, {}),
        state = remember { mutableStateOf(SearchState.Loading) }
    )
}
