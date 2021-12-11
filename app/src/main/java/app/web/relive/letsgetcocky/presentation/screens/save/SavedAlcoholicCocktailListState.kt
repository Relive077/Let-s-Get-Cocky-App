package app.web.relive.letsgetcocky.presentation.screens.save

import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem

data class SavedAlcoholicCocktailListState(
    val isLoading: Boolean = false,
    val data: List<AlcoholicCocktailItem> = emptyList(),
    val errorMessage: String = "",
)