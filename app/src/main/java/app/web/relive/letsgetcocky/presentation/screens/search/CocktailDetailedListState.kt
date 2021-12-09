package app.web.relive.letsgetcocky.presentation.screens.search

import app.web.relive.letsgetcocky.domain.model.CocktailDetailedItem

data class CocktailDetailedListState(
    val isLoading: Boolean = false,
    val data: List<CocktailDetailedItem> = emptyList(),
    val errorMessage: String = "",
)