package app.web.relive.letsgetcocky.data.remote.response

import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem
import com.google.gson.annotations.SerializedName

data class CocktailSearchItemResponse(
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String,
    @SerializedName("idDrink") val idDrink: String,
    @SerializedName("strInstructions") val strInstructions: String?
)

fun CocktailSearchItemResponse.toCocktailSearchItem(): CocktailSearchItem {
    return CocktailSearchItem(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink,
        strInstructions = strInstructions
    )
}