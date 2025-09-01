package com.chazal.fdj.search.data.repository

import com.chazal.fdj.search.data.datasource.SearchDataSource
import com.chazal.fdj.search.data.model.SearchResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface SearchRepository {
    suspend fun getSearch(): List<SearchResponseItem>
}

class SearchRepositoryRemoteImpl(
    val dataSource: SearchDataSource,
) : SearchRepository {
    override suspend fun getSearch(): List<SearchResponseItem> = withContext(Dispatchers.IO) {
        dataSource.getSearchResults().fold(
            onSuccess = {
                it.leagues
            },
            onFailure = { e ->
                throw e
            }
        )
    }
}