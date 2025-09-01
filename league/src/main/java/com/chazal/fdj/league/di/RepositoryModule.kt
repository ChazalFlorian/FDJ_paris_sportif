package com.chazal.fdj.league.di

import com.chazal.fdj.league.data.repository.LeagueRepositoryRemoteImpl
import com.chazal.fdj.shared.domain.league.repository.LeagueRepository
import org.koin.dsl.module

val leagueRepositoryModule = module {
    single<LeagueRepository> {
        LeagueRepositoryRemoteImpl(
            dataSource = get()
        )
    }
}