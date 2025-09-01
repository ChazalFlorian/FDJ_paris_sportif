package com.chazal.fdj.search.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchResponse(
    val leagues: List<SearchResponseItem>,
)

@Keep
@Serializable
data class SearchResponseItem(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String?,
)