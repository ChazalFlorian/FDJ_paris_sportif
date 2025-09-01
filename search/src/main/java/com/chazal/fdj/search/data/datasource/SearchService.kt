package com.chazal.fdj.search.data.datasource

import com.chazal.fdj.search.data.model.SearchResponse
import retrofit2.http.GET

interface SearchService {
    @GET("all_leagues.php")
    suspend fun search(): Result<SearchResponse>
}