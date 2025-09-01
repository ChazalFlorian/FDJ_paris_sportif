package com.chazal.fdj.search.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<SearchState>(SearchState.Loading)
    val uiState: StateFlow<SearchState>
        get() = _uiState.asStateFlow()

    fun searchInput(input: String) {

    }
}