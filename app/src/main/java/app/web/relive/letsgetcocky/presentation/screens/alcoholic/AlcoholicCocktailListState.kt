package app.web.relive.letsgetcocky.presentation.screens.alcoholic

import app.web.relive.letsgetcocky.domain.model.CocktailItem

data class AlcoholicCocktailListState(
    val isLoading: Boolean = false,
    val data: List<CocktailItem> = emptyList(),
    val errorMessage: String = "",
)