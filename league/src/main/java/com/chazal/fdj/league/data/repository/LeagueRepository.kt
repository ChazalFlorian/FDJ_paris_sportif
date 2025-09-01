package com.chazal.fdj.league.data.repository

import com.chazal.fdj.shared.data.league.datasource.LeagueDataSource
import com.chazal.fdj.shared.data.league.model.LeagueResponse
import com.chazal.fdj.shared.domain.league.repository.LeagueRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueRepositoryRemoteImpl(
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