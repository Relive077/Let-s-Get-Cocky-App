package app.web.relive.letsgetcocky.data.repository

import app.web.relive.letsgetcocky.data.local.dao.CocktailDetailsItemDbDao
import app.web.relive.letsgetcocky.data.local.dao.CocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.entity.CocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.toCocktailItem
import app.web.relive.letsgetcocky.data.remote.response.toCocktailDetailsItem
import app.web.relive.letsgetcocky.data.remote.response.toCocktailItem
import app.web.relive.letsgetcocky.data.remote.response.toCocktailSearchItem
import app.web.relive.letsgetcocky.data.remote.service.CocktailApi
import app.web.relive.letsgetcocky.domain.model.*
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val cocktailItemDbDao: CocktailItemDbDao
): CocktailRepository {

    override suspend fun getCocktailList(drinkType: String): List<CocktailItem> {
        return cocktailApi.getCocktailList(drinkType).drinks.map { it.toCocktailItem() }
    }

    override suspend fun searchCocktail(searchString: String): List<CocktailSearchItem>? {
        return cocktailApi.getCocktailListBySearch(searchString).drinks?.map { it.toCocktailSearchItem() }
    }

    override suspend fun saveCocktailItem(cocktailItem: CocktailItem) {
        return cocktailItemDbDao.insertCocktailItemDb(cocktailItem.toCocktailItemDb())
    }

    override suspend fun getAllSavedCocktails(): Flow<List<CocktailItem>> {
        return cocktailItemDbDao.getAllCocktailItems().map { it.map { it.toCocktailItem() } }
    }


}