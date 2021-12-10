package app.web.relive.letsgetcocky.domain.model

import app.web.relive.letsgetcocky.data.local.entity.CocktailItemDb

data class CocktailItem(
    val strDrink: String,
    val strDrinkThumb: String,
    val idDrink: String
)

fun CocktailItem.toCocktailItemDb(): CocktailItemDb {
    return CocktailItemDb(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink
    )
}