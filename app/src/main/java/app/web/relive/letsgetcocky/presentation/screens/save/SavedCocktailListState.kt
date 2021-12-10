package app.web.relive.letsgetcocky.presentation.screens.save

import app.web.relive.letsgetcocky.domain.model.CocktailItem

data class SavedCocktailListState(
    val isLoading: Boolean = false,
    val data: List<CocktailItem> = emptyList(),
    val errorMessage: String = "",
)