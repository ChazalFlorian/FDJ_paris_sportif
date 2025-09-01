package com.chazal.fdj.parisportif

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object Splash

    @Serializable
    data object Search

    @Serializable
    data class League(val league: LeagueParameter)
}

@Serializable
data class LeagueParameter(
    val id: String
)