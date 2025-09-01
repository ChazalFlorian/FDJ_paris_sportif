package com.chazal.fdj.search.domain.interactor

import com.chazal.fdj.search.domain.model.SearchUI

interface FilterSearchUseCase {
    suspend fun filterSearch(query: String, searchResults: SearchUI): SearchUI
}

class FilterSearchUseCaseImpl() : FilterSearchUseCase {
    override suspend fun filterSearch(
        query: String,
        searchResults: SearchUI,
    ): SearchUI {
        return SearchUI(searchResults.items.filter { it.league.contains(query) })
    }
}