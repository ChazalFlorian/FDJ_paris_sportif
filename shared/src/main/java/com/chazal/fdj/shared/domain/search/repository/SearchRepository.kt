package com.chazal.fdj.shared.domain.search.repository

import com.chazal.fdj.shared.data.search.model.SearchResponseItem

interface SearchRepository {
    suspend fun getSearch(): List<SearchResponseItem>
}