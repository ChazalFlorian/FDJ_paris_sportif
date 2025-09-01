package com.chazal.fdj.league.data.repository

import com.chazal.fdj.league.data.datasource.LeagueDataSource
import com.chazal.fdj.league.data.model.LeagueResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface LeagueRepository {

    suspend fun getLeagues(query: String): LeagueResponse
}

class LeagueRepositoryImpl(
    private val dataSource: LeagueDataSource,
) : LeagueRepository {

    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    override suspend fun getLeagues(query: String): LeagueResponse = withContext(dispatcher) {
        dataSource.getLeagues(query).fold(
            onSuccess = {
                it
            },
            onFailure = { e ->
                throw e
            }
        )
    }
}