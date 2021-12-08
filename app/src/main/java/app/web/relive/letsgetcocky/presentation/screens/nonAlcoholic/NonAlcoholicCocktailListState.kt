package app.web.relive.letsgetcocky.presentation.screens.nonAlcoholic

import app.web.relive.letsgetcocky.domain.model.CocktailItem

data class NonAlcoholicCocktailListState(
    val isLoading: Boolean = false,
    val data: List<CocktailItem> = emptyList(),
    val errorMessage: String = "",
)