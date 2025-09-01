package com.chazal.fdj.shared.data.league.datasource

import com.chazal.fdj.shared.data.league.model.LeagueResponse

interface LeagueDataSource {
    suspend fun getLeagues(query: String): Result<LeagueResponse>
}