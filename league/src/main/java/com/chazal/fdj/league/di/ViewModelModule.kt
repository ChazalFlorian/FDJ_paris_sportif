package com.chazal.fdj.league.di

import com.chazal.fdj.league.presentation.LeagueViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val leagueViewModelModule = module {
    viewModel<LeagueViewModel> {
        LeagueViewModel(
            useCase = get()
        )
    }
}