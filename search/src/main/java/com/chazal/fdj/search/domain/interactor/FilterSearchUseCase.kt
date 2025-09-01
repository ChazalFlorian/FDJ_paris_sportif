package com.chazal.fdj.search.domain.interactor

import com.chazal.fdj.search.domain.model.SearchItemBlockUI
import com.chazal.fdj.search.domain.model.SearchUI

interface FilterSearchUseCase {
    suspend fun filterSearch(
        query: String,
        searchResults: List<SearchItemBlockUI>,
    ): List<SearchItemBlockUI>
}

class FilterSearchUseCaseImpl() : FilterSearchUseCase {
    override suspend fun filterSearch(
        query: String,
        searchResults: List<SearchItemBlockUI>,
    ): List<SearchItemBlockUI> {
        return searchResults.filter { it.league.contains(query) }
    }
}