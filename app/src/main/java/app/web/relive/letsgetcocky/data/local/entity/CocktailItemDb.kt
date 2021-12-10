package app.web.relive.letsgetcocky.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.web.relive.letsgetcocky.domain.model.CocktailItem

@Entity
data class CocktailItemDb(
    val strDrink: String,
    val strDrinkThumb: String,
    @PrimaryKey val idDrink: String,
    val isSaved: Boolean = false
)

fun CocktailItemDb.toCocktailItem(): CocktailItem {
    return CocktailItem(
        idDrink = idDrink,
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb
    )
}
