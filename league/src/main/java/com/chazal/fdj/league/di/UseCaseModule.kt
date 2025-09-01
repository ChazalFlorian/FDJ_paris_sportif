package com.chazal.fdj.league.di

import com.chazal.fdj.league.domain.interactor.GetLeaguesUseCase
import com.chazal.fdj.league.domain.interactor.GetLeaguesUseCaseImpl
import org.koin.dsl.module

val leagueUseCaseModule = module {
    factory<GetLeaguesUseCase> {
        GetLeaguesUseCaseImpl(
            repository = get()
        )
    }
}