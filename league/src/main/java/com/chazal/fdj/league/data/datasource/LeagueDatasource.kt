package com.chazal.fdj.league.data.datasource

import com.chazal.fdj.shared.data.league.datasource.LeagueDataSource
import com.chazal.fdj.shared.data.league.model.LeagueResponse

class LeagueDataSourceImpl(
    private val service: LeagueService,
) : LeagueDataSource {
    override suspend fun getLeagues(query: String): Result<LeagueResponse> {
        return service.getLeagueDetail(query)
    }
}