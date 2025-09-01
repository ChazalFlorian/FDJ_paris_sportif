package com.chazal.fdj.league.di

import com.chazal.fdj.league.data.repository.LeagueRepository
import com.chazal.fdj.league.data.repository.LeagueRepositoryImpl
import org.koin.dsl.module

val leagueRepositoryModule = module {
    single<LeagueRepository> {
        LeagueRepositoryImpl(
            dataSource = get()
        )
    }
}