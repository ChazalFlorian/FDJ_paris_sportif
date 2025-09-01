package com.chazal.fdj.shared.domain.league.repository

import com.chazal.fdj.shared.data.league.model.LeagueResponse

interface LeagueRepository {

    suspend fun getLeagues(query: String): LeagueResponse
}