package app.web.relive.letsgetcocky.domain.repository

import app.web.relive.letsgetcocky.data.local.entity.CocktailItemDb
import app.web.relive.letsgetcocky.domain.model.CocktailDetailsItem
import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import kotlinx.coroutines.flow.Flow

interface CocktailRepository {

    suspend fun getCocktailList(drinkType: String): List<CocktailItem>

    suspend fun searchCocktail(searchString: String): List<CocktailSearchItem>?

    suspend fun saveCocktailItem(cocktailItem: CocktailItem)

    suspend fun getAllSavedCocktails(): Flow<List<CocktailItem>>

}