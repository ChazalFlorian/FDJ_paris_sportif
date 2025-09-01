package com.chazal.fdj.parisportif

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object Search

    @Serializable
    data class League(val source: String)
}