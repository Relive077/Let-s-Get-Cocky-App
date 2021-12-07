package app.web.relive.letsgetcocky.data.remote.response

import app.web.relive.letsgetcocky.domain.model.CocktailItem

data class CocktailItemResponse(
    val strDrink: String,
    val strDrinkThumb: String,
    val idDrink: String
)

fun CocktailItemResponse.toCocktailItem(): CocktailItem {
    return CocktailItem(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink
    )
}