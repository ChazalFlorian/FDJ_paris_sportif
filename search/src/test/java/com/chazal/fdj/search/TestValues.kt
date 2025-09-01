package com.chazal.fdj.search

import com.chazal.fdj.shared.data.search.model.SearchResponse
import com.chazal.fdj.shared.data.search.model.SearchResponseItem
import com.chazal.fdj.search.domain.model.SearchItemBlockUI
import com.chazal.fdj.search.domain.model.SearchUI
import com.chazal.fdj.search.presentation.SearchState

internal val dummySearchResultItem = listOf(
    SearchResponseItem(
        idLeague = "test",
        strLeague = "filter",
        strLeagueAlternate = "",
        strSport = ""
    ),
    SearchResponseItem(
        idLeague = "test",
        strLeague = "kebab",
        strLeagueAlternate = "",
        strSport = ""
    ),
    SearchResponseItem(
        idLeague = "test",
        strLeague = "shawarma",
        strLeagueAlternate = "",
        strSport = ""
    )
)

internal val dummyFilteredSearchResultItem = listOf(
    SearchResponseItem(
        idLeague = "test",
        strLeague = "shawarma",
        strLeagueAlternate = "",
        strSport = ""
    )
)

internal val dummySearchResponse = SearchResponse(
    leagues = dummySearchResultItem
)

internal val dummySuccessResponse = SearchUI(
    listOf(
        SearchItemBlockUI(
            id = "test",
            league = "filter",
            leagueAlternate = "",
            sport = ""
        ),
        SearchItemBlockUI(
            id = "test",
            league = "kebab",
            leagueAlternate = "",
            sport = ""
        ),
        SearchItemBlockUI(
            id = "test",
            league = "shawarma",
            leagueAlternate = "",
            sport = ""
        ),
    )
)

internal val dummySuccessState = SearchState.Success(
    SearchUI(
        listOf(
            SearchItemBlockUI(
                id = "test",
                league = "filter",
                leagueAlternate = "",
                sport = ""
            ),
            SearchItemBlockUI(
                id = "test",
                league = "kebab",
                leagueAlternate = "",
                sport = ""
            ),
            SearchItemBlockUI(
                id = "test",
                league = "shawarma",
                leagueAlternate = "",
                sport = ""
            ),
        )
    )
)

internal val dummyFiltered = SearchState.Success(
    SearchUI(
        listOf(
            SearchItemBlockUI(
                id = "test",
                league = "shawarma",
                leagueAlternate = "",
                sport = ""
            )
        )
    )
)