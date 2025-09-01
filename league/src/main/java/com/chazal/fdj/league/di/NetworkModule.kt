package com.chazal.fdj.league.di

import com.chazal.fdj.league.data.datasource.LeagueService
import com.chazal.fdj.network.providesClient
import org.koin.dsl.module

val leagueNetworkModule = module {
    factory {
        val retrofit = providesClient()
        retrofit.create(LeagueService::class.java)
    }
}