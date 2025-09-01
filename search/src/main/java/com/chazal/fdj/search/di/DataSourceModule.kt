package com.chazal.fdj.search.di

import com.chazal.fdj.search.data.datasource.SearchDataSource
import com.chazal.fdj.search.data.datasource.SearchDataSourceImpl
import org.koin.dsl.module

val searchDataSourceModule = module {
    single<SearchDataSource> {
        SearchDataSourceImpl(
            searchService = get()
        )
    }
}