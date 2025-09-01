package com.chazal.fdj.league.domain.mapper

import com.chazal.fdj.league.data.model.LeagueResponse
import com.chazal.fdj.league.data.model.TeamResponse
import com.chazal.fdj.league.domain.model.LeagueItemBlockUI
import com.chazal.fdj.league.domain.model.LeagueUI

internal fun LeagueResponse.toLeagueUI() = LeagueUI(
    content = teams.map {
        it.toLeagueItemBlockUI()
    }.filterResponse()
)

private fun TeamResponse.toLeagueItemBlockUI() = LeagueItemBlockUI(
    logoUrl = strLogo ?: "",
    description = strDescriptionFR ?: ""
)

private fun List<LeagueItemBlockUI>.filterResponse(): List<LeagueItemBlockUI> =
    sortedBy { it.description }
        .asReversed()
        .filterIndexed { index, _ ->
            index % 2 == 0
        }