package com.chazal.fdj.league.domain.model

data class LeagueUI(
    val content: List<LeagueItemBlockUI>
)

data class LeagueItemBlockUI(
    val logoUrl: String,
    val description: String
)
