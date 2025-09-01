package com.chazal.fdj.search.data.repository

import com.chazal.fdj.shared.data.search.datasource.SearchDataSource
import com.chazal.fdj.shared.data.search.model.SearchResponseItem
import com.chazal.fdj.shared.domain.search.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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