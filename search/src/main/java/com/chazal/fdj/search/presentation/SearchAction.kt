package com.chazal.fdj.search.presentation

data class SearchAction(
    val search: (input: String) -> Unit,
)