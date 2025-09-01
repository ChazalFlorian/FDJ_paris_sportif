package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.search.di.searchRepositoryModule
import org.koin.dsl.module

val repositoryModule = module {
    includes(
        searchRepositoryModule,
    )
}