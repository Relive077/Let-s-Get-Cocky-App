package app.web.relive.letsgetcocky.data.remote.response

import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.NonAlcoholicCocktailItemDb
import com.google.gson.annotations.SerializedName

data class CocktailItemResponse(
    @SerializedName("strDrink") val strDrink: String,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String,
    @SerializedName("idDrink") val idDrink: String
)

fun CocktailItemResponse.toAlcoholicCocktailItemDb(): AlcoholicCocktailItemDb {
    return AlcoholicCocktailItemDb(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink,
        isSaved = false
    )
}

fun CocktailItemResponse.toNonAlcoholicCocktailItemDb(): NonAlcoholicCocktailItemDb {
    return NonAlcoholicCocktailItemDb(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink,
        isSaved = false
    )
}