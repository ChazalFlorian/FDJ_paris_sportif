package com.chazal.fdj.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.chazal.fdj.search.domain.interactor.GetSearchUseCase
import com.chazal.fdj.search.domain.model.SearchItemBlockUI
import com.chazal.fdj.search.domain.model.SearchUI
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

    private var _allResults: MutableList<SearchItemBlockUI> = mutableListOf()

    init {
        searchInput()
    }

    private fun searchInput() {
        _uiState.value = SearchState.Loading
        viewModelScope.launch {
            try {
                val res = getSearchUseCase.getSearchResults()
                _uiState.value = SearchState.Success(
                    content = res
                )
                _allResults = res.items.toMutableList()
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
                _uiState.value = (_uiState.value as SearchState.Success).copy(
                    content = SearchUI(
                        items = filterSearchUseCase.filterSearch(
                            query = input,
                            searchResults = _allResults
                        )
                    )
                )
            }
        }
    }
}