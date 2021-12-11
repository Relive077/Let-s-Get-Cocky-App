package app.web.relive.letsgetcocky.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem

@Entity
data class NonAlcoholicCocktailItemDb(
    val strDrink: String,
    val strDrinkThumb: String,
    @PrimaryKey val idDrink: String,
    val isSaved: Boolean = false
)

fun NonAlcoholicCocktailItemDb.toNonAlcoholicCocktailItem(): NonAlcoholicCocktailItem {
    return NonAlcoholicCocktailItem(
        strDrink = strDrink,
        strDrinkThumb = strDrinkThumb,
        idDrink = idDrink,
        isSaved = isSaved
    )
}
