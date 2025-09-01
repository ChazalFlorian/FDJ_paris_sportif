package com.chazal.fdj.search.di

import com.chazal.fdj.search.presentation.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val searchViewModelModule = module {
    viewModel<SearchViewModel> {
        SearchViewModel(
            getSearchUseCase = get(),
            filterSearchUseCase = get()
        )
    }
}