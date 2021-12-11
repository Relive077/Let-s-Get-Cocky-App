package app.web.relive.letsgetcocky.presentation.screens.save

import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem

data class SavedNonAlcoholicCocktailListState(
    val isLoading: Boolean = false,
    val data: List<NonAlcoholicCocktailItem> = emptyList(),
    val errorMessage: String = "",
)