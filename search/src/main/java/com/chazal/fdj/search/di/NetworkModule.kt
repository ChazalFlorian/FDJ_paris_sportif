package com.chazal.fdj.search.di

import com.chazal.fdj.network.providesClient
import com.chazal.fdj.search.data.datasource.SearchService
import org.koin.dsl.module

val searchNetworkModule = module {
    factory {
        val retrofit = providesClient()
        retrofit.create(SearchService::class.java)
    }
}