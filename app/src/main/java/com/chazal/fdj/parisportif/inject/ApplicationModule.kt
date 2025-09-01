package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.league.data.datasource.LeagueService
import com.chazal.fdj.parisportif.core.network.providesClient
import com.chazal.fdj.search.data.datasource.SearchService
import org.koin.dsl.module

val applicationModule = module {

    factory {
        val retrofit = providesClient()
        retrofit.create(SearchService::class.java)
    }

    factory {
        val retrofit = providesClient()
        retrofit.create(LeagueService::class.java)
    }
}