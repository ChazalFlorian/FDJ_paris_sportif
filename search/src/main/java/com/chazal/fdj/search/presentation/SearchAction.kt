package com.chazal.fdj.search.presentation

import com.chazal.fdj.search.domain.model.SearchItemBlockUI

data class SearchAction(
    val search: (input: String) -> Unit,
    val onLeagueClick: (leagueId: String) -> Unit,
)