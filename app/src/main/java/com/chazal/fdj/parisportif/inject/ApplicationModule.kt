package com.chazal.fdj.parisportif.inject

import com.chazal.fdj.parisportif.core.network.providesClient
import org.koin.dsl.module

val applicationModule = module {

    factory {
        val retrofit = providesClient()
        retrofit.create(String::class.java) // TODO add proper Services here
    }
}