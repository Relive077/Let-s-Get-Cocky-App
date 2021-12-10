package app.web.relive.letsgetcocky.presentation.screens.search

import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem

data class SearchCocktailListState(
    val isLoading: Boolean = false,
    val data: List<CocktailSearchItem> = emptyList(),
    val errorMessage: String = "",
)