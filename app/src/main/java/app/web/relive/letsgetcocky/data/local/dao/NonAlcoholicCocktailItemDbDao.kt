package app.web.relive.letsgetcocky.data.local.dao

import androidx.room.*
import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.NonAlcoholicCocktailItemDb
import kotlinx.coroutines.flow.Flow

@Dao
interface NonAlcoholicCocktailItemDbDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNonAlcoholicCocktailItemDbList(nonAlcoholicCocktailItemDbList: List<NonAlcoholicCocktailItemDb>)

    @Query("SELECT * FROM NonAlcoholicCocktailItemDb")
    fun getCompleteNonAlcoholicCocktailItemList(): Flow<List<NonAlcoholicCocktailItemDb>>

    @Update
    suspend fun saveNonAlcoholicCocktailItemDb(nonAlcoholicCocktailItemDb: NonAlcoholicCocktailItemDb)

    @Update
    suspend fun unsaveNonAlcoholicCocktailItemDb(nonAlcoholicCocktailItemDb: NonAlcoholicCocktailItemDb)

    @Query("SELECT * FROM NonAlcoholicCocktailItemDb WHERE isSaved=1")
    fun getSavedNonAlcoholicCocktailItemList(): Flow<List<NonAlcoholicCocktailItemDb>>
    
}