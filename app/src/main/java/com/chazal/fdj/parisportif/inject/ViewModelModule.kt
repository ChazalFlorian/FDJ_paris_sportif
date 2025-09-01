package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.league.di.leagueViewModelModule
import com.chazal.fdj.search.di.searchViewModelModule
import org.koin.dsl.module

val viewModelModule = module {
    includes(
        searchViewModelModule,
        leagueViewModelModule
    )
}