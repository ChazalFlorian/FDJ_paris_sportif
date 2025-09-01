package com.chazal.fdj.league.di

import com.chazal.fdj.league.data.datasource.LeagueDataSource
import com.chazal.fdj.league.data.datasource.LeagueDataSourceImpl
import org.koin.dsl.module

val leagueDataSourceModule = module {
    single<LeagueDataSource> {
        LeagueDataSourceImpl(
            service = get()
        )
    }
}