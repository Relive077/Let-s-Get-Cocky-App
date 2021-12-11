package app.web.relive.letsgetcocky.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem

@Entity
data class AlcoholicCocktailItemDb(
    val strDrink: String,
    val strDrinkThumb: String,
    @PrimaryKey val idDrink: String,
    val isSaved: Boolean
)

fun AlcoholicCocktailItemDb.toAlcoholicCocktailItem(): AlcoholicCocktailItem {
    return AlcoholicCocktailItem(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink,
        isSaved = isSaved
    )
}
