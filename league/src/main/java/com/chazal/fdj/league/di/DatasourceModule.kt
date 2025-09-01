package com.chazal.fdj.league.di

import com.chazal.fdj.league.data.datasource.LeagueDataSourceImpl
import com.chazal.fdj.shared.data.league.datasource.LeagueDataSource
import org.koin.dsl.module

val leagueDataSourceModule = module {
    single<LeagueDataSource> {
        LeagueDataSourceImpl(
            service = get()
        )
    }
}