package app.web.relive.letsgetcocky.presentation.screens.nonAlcoholic

import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem

data class NonAlcoholicCocktailListState(
    val isLoading: Boolean = false,
    val data: List<NonAlcoholicCocktailItem> = emptyList(),
    val errorMessage: String = "",
)