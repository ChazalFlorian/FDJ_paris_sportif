package com.chazal.fdj.search.data.datasource

import com.chazal.fdj.shared.data.search.datasource.SearchDataSource
import com.chazal.fdj.shared.data.search.model.SearchResponse

class SearchDataSourceImpl(
    private val searchService: SearchService,
) : SearchDataSource {
    override suspend fun getSearchResults(): Result<SearchResponse> {
        return searchService.search()
    }
}