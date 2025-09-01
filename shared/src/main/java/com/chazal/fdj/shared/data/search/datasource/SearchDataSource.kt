package com.chazal.fdj.shared.data.search.datasource

import com.chazal.fdj.shared.data.search.model.SearchResponse

interface SearchDataSource {
    suspend fun getSearchResults(): Result<SearchResponse>
}