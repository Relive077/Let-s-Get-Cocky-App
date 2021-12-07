package app.web.relive.letsgetcocky.domain.repository

import app.web.relive.letsgetcocky.domain.model.CocktailItem

interface CocktailRepository {
    suspend fun getCocktailList(drinkType: String): List<CocktailItem>
}