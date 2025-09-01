package com.chazal.fdj.parisportif

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object Splash

    @Serializable
    data object Search
}