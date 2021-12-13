package app.web.relive.letsgetcocky.data.repository

import app.web.relive.letsgetcocky.data.local.dao.AlcoholicCocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.dao.NonAlcoholicCocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.NonAlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.toAlcoholicCocktailItem
import app.web.relive.letsgetcocky.data.local.entity.toNonAlcoholicCocktailItem
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.data.remote.response.*
import app.web.relive.letsgetcocky.data.remote.service.CocktailApi
import app.web.relive.letsgetcocky.domain.model.*
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailApi: CocktailApi,
    private val alcoholicCocktailItemDbDao: AlcoholicCocktailItemDbDao,
    private val nonAlcoholicCocktailItemDbDao: NonAlcoholicCocktailItemDbDao
): CocktailRepository {

    override fun getAlcoholicCocktailList():
            Flow<Resource<List<AlcoholicCocktailItem>>> = flow {

        try {
            emit(Resource.Loading<List<AlcoholicCocktailItem>>())
            val apiAlcoholicCocktails = cocktailApi.getCocktailList("Alcoholic").drinks
            alcoholicCocktailItemDbDao.insertAlcoholicCocktailItemDbList(
                apiAlcoholicCocktails.map { it.toAlcoholicCocktailItemDb() })
            alcoholicCocktailItemDbDao.getCompleteAlcoholicCocktailItemList().collect {
                emit(Resource.Success<List<AlcoholicCocktailItem>>(it.map { it.toAlcoholicCocktailItem() }))
                }
        } catch (e: HttpException) {
            emit(Resource.Error<List<AlcoholicCocktailItem>>(
                e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<AlcoholicCocktailItem>>(
                "Couldn't reach server. Check your internet connection."))
        }


    }

    override suspend fun updateAlcoholicCocktailItemAsFavorite(alcoholicCocktailItemDb: AlcoholicCocktailItemDb) {
        alcoholicCocktailItemDbDao.saveAlcoholicCocktailItemDb(alcoholicCocktailItemDb)
    }

    override suspend fun updateAlcoholicCocktailItemAsNotFavorite(alcoholicCocktailItemDb: AlcoholicCocktailItemDb) {
        alcoholicCocktailItemDbDao.unsaveAlcoholicCocktailItemDb(alcoholicCocktailItemDb)
    }

    override fun getSavedAlcoholicCocktailList(): Flow<Resource<List<AlcoholicCocktailItem>>> = flow {
        try {
            emit(Resource.Loading<List<AlcoholicCocktailItem>>())
            alcoholicCocktailItemDbDao.getSavedAlcoholicCocktailItemList().collect {
                emit(Resource.Success<List<AlcoholicCocktailItem>>(it.map { it.toAlcoholicCocktailItem() }))
            }
        } catch (e: IOException) {
            emit(Resource.Error<List<AlcoholicCocktailItem>>("An unexpected error occurred"))
        }

    }

    override fun getNonAlcoholicCocktailList():
            Flow<Resource<List<NonAlcoholicCocktailItem>>> = flow {

        try {
            emit(Resource.Loading<List<NonAlcoholicCocktailItem>>())
            val apiNonAlcoholicCocktails = cocktailApi.getCocktailList("Non_Alcoholic").drinks
            nonAlcoholicCocktailItemDbDao.insertNonAlcoholicCocktailItemDbList(
                apiNonAlcoholicCocktails.map { it.toNonAlcoholicCocktailItemDb() })
            nonAlcoholicCocktailItemDbDao.
            getCompleteNonAlcoholicCocktailItemList().collect {
                emit(Resource.Success<List<NonAlcoholicCocktailItem>>(it.map { it.toNonAlcoholicCocktailItem() }))
            }
        } catch (e: HttpException) {
            emit(Resource.Error<List<NonAlcoholicCocktailItem>>(
                e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<NonAlcoholicCocktailItem>>(
                "Couldn't reach server. Check your internet connection."))
        }


    }

    override suspend fun updateNonAlcoholicCocktailItemAsFavorite(nonAlcoholicCocktailItemDb: NonAlcoholicCocktailItemDb) {
        nonAlcoholicCocktailItemDbDao.saveNonAlcoholicCocktailItemDb(nonAlcoholicCocktailItemDb)
    }

    override suspend fun updateNonAlcoholicCocktailItemAsNotFavorite(nonAlcoholicCocktailItemDb: NonAlcoholicCocktailItemDb) {
        nonAlcoholicCocktailItemDbDao.unsaveNonAlcoholicCocktailItemDb(nonAlcoholicCocktailItemDb)
    }

    override fun getSavedNonAlcoholicCocktailList(): Flow<Resource<List<NonAlcoholicCocktailItem>>> = flow {
        try {
            emit(Resource.Loading<List<NonAlcoholicCocktailItem>>())
            nonAlcoholicCocktailItemDbDao.getSavedNonAlcoholicCocktailItemList().collect {
                emit(Resource.Success<List<NonAlcoholicCocktailItem>>(it.map { it.toNonAlcoholicCocktailItem() }))
            }
        } catch (e: IOException) {
            emit(Resource.Error<List<NonAlcoholicCocktailItem>>("An unexpected error occurred"))
        }

    }

    override fun searchCocktail(searchString: String):
            Flow<Resource<List<CocktailSearchItem>?>> = flow {

        try {
            emit(Resource.Loading<List<CocktailSearchItem>?>())
            val cocktailSearchList = cocktailApi.
            getCocktailListBySearchString(searchString).drinks?.map { it.toCocktailSearchItem() }
            emit(Resource.Success<List<CocktailSearchItem>?>(cocktailSearchList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CocktailSearchItem>?>
                (e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<CocktailSearchItem>?>
                ("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCocktailDetails(idDrink: String):
            Flow<Resource<CocktailDetailsItem>> = flow {

        try {
            emit(Resource.Loading<CocktailDetailsItem>())
            val cocktailDetailsList =
                cocktailApi.getCocktailDetailsById(idDrink).drinks[0].toCocktailDetailsItem()
            emit(Resource.Success<CocktailDetailsItem>(cocktailDetailsList))
        } catch (e: HttpException) {
            emit(Resource.Error<CocktailDetailsItem>
                (e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CocktailDetailsItem>
                ("Couldn't reach server. Check your internet connection."))
        }
    }



}