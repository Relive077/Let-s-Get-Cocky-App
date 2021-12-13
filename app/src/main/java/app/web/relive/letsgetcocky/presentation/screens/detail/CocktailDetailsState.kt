package app.web.relive.letsgetcocky.presentation.screens.detail

import app.web.relive.letsgetcocky.domain.model.CocktailDetailsItem

data class CocktailDetailsState(
    val isLoading: Boolean = false,
    val data: CocktailDetailsItem =
        CocktailDetailsItem("","","","","","",
            "","","","","","",
            "","","","","","",
            "","","","","","",
            "","","","","","",
            "","","",""),
    val errorMessage: String = "",
)