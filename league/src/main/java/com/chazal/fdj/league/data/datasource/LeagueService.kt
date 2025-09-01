package com.chazal.fdj.league.data.datasource

import com.chazal.fdj.shared.data.league.model.LeagueResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueService {
    @GET("search_all_teams.php")
    suspend fun getLeagueDetail(@Query("l") query: String): Result<LeagueResponse>
}