package com.chazal.fdj.search.di

import com.chazal.fdj.search.data.datasource.SearchDataSourceImpl
import com.chazal.fdj.shared.data.search.datasource.SearchDataSource
import org.koin.dsl.module

val searchDataSourceModule = module {
    single<SearchDataSource> {
        SearchDataSourceImpl(
            searchService = get()
        )
    }
}