package com.chazal.fdj.league.data.datasource

import com.chazal.fdj.league.data.model.LeagueResponse

interface LeagueDataSource {
    suspend fun getLeagues(query: String) : Result<LeagueResponse>
}

class LeagueDataSourceImpl(
    private val service: LeagueService
) : LeagueDataSource {
    override suspend fun getLeagues(query: String): Result<LeagueResponse> {
        return service.getLeagueDetail(query)
    }
}