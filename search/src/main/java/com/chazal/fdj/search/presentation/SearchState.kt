package com.chazal.fdj.search.presentation

import com.chazal.fdj.search.domain.model.SearchUI

sealed class SearchState {
    data object Loading: SearchState()
    data class Success(val content: SearchUI): SearchState()
    data class Error(val message: String): SearchState()
}