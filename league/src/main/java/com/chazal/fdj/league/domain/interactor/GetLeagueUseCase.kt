package com.chazal.fdj.league.domain.interactor

import com.chazal.fdj.league.data.repository.LeagueRepository
import com.chazal.fdj.league.domain.mapper.toLeagueUI
import com.chazal.fdj.league.domain.model.LeagueUI

interface GetLeaguesUseCase {
    suspend fun getLeagues(query: String): LeagueUI
}

class GetLeaguesUseCaseImpl(
    private val repository: LeagueRepository,
) : GetLeaguesUseCase {
    override suspend fun getLeagues(query: String): LeagueUI =
        repository.getLeagues(query).toLeagueUI()
}