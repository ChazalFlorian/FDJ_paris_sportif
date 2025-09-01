package com.chazal.fdj.search.domain.interactor

import com.chazal.fdj.search.domain.mapper.toSearchItemListBlockUI
import com.chazal.fdj.search.domain.model.SearchUI
import com.chazal.fdj.shared.domain.search.repository.SearchRepository

interface GetSearchUseCase {
    suspend fun getSearchResults(): SearchUI
}

class GetSearchUseCaseImpl(
    val repository: SearchRepository,
) : GetSearchUseCase {
    override suspend fun getSearchResults(): SearchUI {
        return repository.getSearch().toSearchItemListBlockUI()
    }
}