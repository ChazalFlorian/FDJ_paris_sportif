package com.chazal.fdj.shared.data.search.model

import androidx.annotation.Keep

@Keep
data class SearchResponse(
    val leagues: List<SearchResponseItem>,
)

@Keep
data class SearchResponseItem(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String?,
)