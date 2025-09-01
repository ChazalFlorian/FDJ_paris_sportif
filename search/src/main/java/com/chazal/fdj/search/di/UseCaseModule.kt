package com.chazal.fdj.search.di

import com.chazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.chazal.fdj.search.domain.interactor.FilterSearchUseCaseImpl
import com.chazal.fdj.search.domain.interactor.GetSearchUseCase
import com.chazal.fdj.search.domain.interactor.GetSearchUseCaseImpl
import org.koin.dsl.module

val searchUseCaseModule = module {
    factory<GetSearchUseCase> {
        GetSearchUseCaseImpl(
            repository = get()
        )
    }
    factory<FilterSearchUseCase> {
        FilterSearchUseCaseImpl()
    }
}