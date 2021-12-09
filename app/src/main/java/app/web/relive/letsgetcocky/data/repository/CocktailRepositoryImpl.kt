package app.web.relive.letsgetcocky.data.repository

import app.web.relive.letsgetcocky.data.remote.response.toCocktailDetailedItem
import app.web.relive.letsgetcocky.data.remote.response.toCocktailItem
import app.web.relive.letsgetcocky.data.remote.service.CocktailApi
import app.web.relive.letsgetcocky.domain.model.CocktailDetailedItem
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailApi: CocktailApi
): CocktailRepository {

    override suspend fun getCocktailList(drinkType: String): List<CocktailItem> {
        return cocktailApi.getCocktailList(drinkType).drinks.map { it.toCocktailItem() }
    }

    override suspend fun getCocktailDetailedList(searchString: String): List<CocktailDetailedItem>? {
        return cocktailApi.getCocktailListBySearch(searchString).drinks?.map { it.toCocktailDetailedItem() }
    }

}