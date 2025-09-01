package com.chazal.fdj.search.di

import com.chazal.fdj.search.data.repository.SearchRepository
import com.chazal.fdj.search.data.repository.SearchRepositoryRemoteImpl
import org.koin.dsl.module

val searchRepositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryRemoteImpl(
            dataSource = get()
        )
    }
}