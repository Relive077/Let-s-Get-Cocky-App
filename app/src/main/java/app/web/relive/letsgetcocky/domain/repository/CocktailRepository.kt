package app.web.relive.letsgetcocky.domain.repository

import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.NonAlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem
import kotlinx.coroutines.flow.Flow

interface CocktailRepository {

    //Alcoholic

    fun getAlcoholicCocktailList(): Flow<Resource<List<AlcoholicCocktailItem>>>

    suspend fun updateAlcoholicCocktailItemAsFavorite(alcoholicCocktailItemDb: AlcoholicCocktailItemDb)

    fun getSavedAlcoholicCocktailList(): Flow<Resource<List<AlcoholicCocktailItem>>>


    //NonAlcoholic

    fun getNonAlcoholicCocktailList(): Flow<Resource<List<NonAlcoholicCocktailItem>>>

    suspend fun updateNonAlcoholicCocktailItemAsFavorite(nonAlcoholicCocktailItemDb: NonAlcoholicCocktailItemDb)

    fun getSavedNonAlcoholicCocktailList(): Flow<Resource<List<NonAlcoholicCocktailItem>>>



    fun searchCocktail(searchString: String): Flow<Resource<List<CocktailSearchItem>?>>

}