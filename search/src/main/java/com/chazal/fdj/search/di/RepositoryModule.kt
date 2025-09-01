package com.chazal.fdj.search.di

import com.chazal.fdj.search.data.repository.SearchRepositoryRemoteImpl
import com.chazal.fdj.shared.domain.search.repository.SearchRepository
import org.koin.dsl.module

val searchRepositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryRemoteImpl(
            dataSource = get()
        )
    }
}