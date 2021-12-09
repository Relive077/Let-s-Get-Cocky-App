package app.web.relive.letsgetcocky.data.remote.response

import app.web.relive.letsgetcocky.domain.model.CocktailDetailedItem
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import com.google.gson.annotations.SerializedName

data class CocktailDetailedItemResponse(
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String,
    @SerializedName("idDrink") val idDrink: String,
    @SerializedName("strInstructions") val strInstructions: String?
)

fun CocktailDetailedItemResponse.toCocktailDetailedItem(): CocktailDetailedItem {
    return CocktailDetailedItem(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink,
        strInstructions = strInstructions
    )
}