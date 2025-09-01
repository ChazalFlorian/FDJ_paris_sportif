package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.search.di.searchUseCaseModule
import org.koin.dsl.module

val useCaseModule = module {
    includes(
        searchUseCaseModule
    )
}