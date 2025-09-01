package com.chazal.fdj.league.presentation

import com.chazal.fdj.league.domain.model.LeagueUI

sealed class LeagueScreenState {
    data object Loading : LeagueScreenState()
    data class Success(val content: LeagueUI) : LeagueScreenState()
    data class Error(val message: String) : LeagueScreenState()
}