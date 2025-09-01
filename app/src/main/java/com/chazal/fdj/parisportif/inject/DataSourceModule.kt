package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.league.di.leagueDataSourceModule
import com.chazal.fdj.search.di.searchDataSourceModule
import org.koin.dsl.module

val dataSourceModule = module {
    includes(
        searchDataSourceModule,
        leagueDataSourceModule
    )
}