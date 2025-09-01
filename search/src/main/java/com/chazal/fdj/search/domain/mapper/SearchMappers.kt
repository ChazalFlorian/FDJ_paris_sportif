package com.chazal.fdj.search.domain.mapper

import com.chazal.fdj.shared.data.search.model.SearchResponseItem
import com.chazal.fdj.search.domain.model.SearchItemBlockUI
import com.chazal.fdj.search.domain.model.SearchUI

internal fun List<SearchResponseItem>.toSearchItemListBlockUI(): SearchUI = SearchUI(
    items = map {
        it.toSearchItemBlockUI()
    }
)

private fun SearchResponseItem.toSearchItemBlockUI(): SearchItemBlockUI = SearchItemBlockUI(
    id = idLeague,
    league = strLeague,
    sport = strSport,
    leagueAlternate = strLeagueAlternate ?: ""
)