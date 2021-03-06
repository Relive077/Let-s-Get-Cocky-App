package app.web.relive.letsgetcocky.presentation.screens.alcoholic

import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem

data class AlcoholicCocktailListState(
    val isLoading: Boolean = false,
    val data: List<AlcoholicCocktailItem> = emptyList(),
    val errorMessage: String = "",
)