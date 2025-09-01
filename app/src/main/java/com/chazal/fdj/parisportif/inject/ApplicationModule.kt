package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.league.di.leagueNetworkModule
import com.chazal.fdj.search.di.searchNetworkModule
import org.koin.dsl.module

val applicationModule = module {

    includes(
        leagueNetworkModule,
        searchNetworkModule
    )
}