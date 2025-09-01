package com.chazal.fdj.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.chazal.fdj.search.domain.interactor.GetSearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getSearchUseCase: GetSearchUseCase,
    private val filterSearchUseCase: FilterSearchUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<SearchState>(SearchState.Loading)
    val uiState: StateFlow<SearchState>
        get() = _uiState.asStateFlow()

    init {
        searchInput()
    }

    private fun searchInput() {
        _uiState.value = SearchState.Loading
        viewModelScope.launch {
            try {
                _uiState.value = SearchState.Success(
                    content = getSearchUseCase.getSearchResults()
                )
                getSearchUseCase.getSearchResults()
            } catch (e: Exception) {
                _uiState.value = SearchState.Error(
                    message = e.message ?: ""
                )
            }
        }
    }

    fun filterSearchResults(input: String) {
        if (_uiState.value is SearchState.Success) {
            viewModelScope.launch {
                when (
                    val result = filterSearchUseCase.filterSearch(
                        input,
                        (_uiState.value as SearchState.Success).content
                    )
                ) {

                }
            }
        }
    }
}