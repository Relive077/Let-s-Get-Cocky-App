package app.web.relive.letsgetcocky.data.remote.response

import app.web.relive.letsgetcocky.domain.model.CocktailItem
import com.google.gson.annotations.SerializedName

data class CocktailItemResponse(
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String,
    @SerializedName("idDrink") val idDrink: String
)

fun CocktailItemResponse.toCocktailItem(): CocktailItem {
    return CocktailItem(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink
    )
}