package app.web.relive.letsgetcocky.data.local.dao

import androidx.room.*
import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import kotlinx.coroutines.flow.Flow

@Dao
interface AlcoholicCocktailItemDbDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlcoholicCocktailItemDbList(alcoholicCocktailItemDbList: List<AlcoholicCocktailItemDb>)

    @Query("SELECT * FROM AlcoholicCocktailItemDb")
    fun getCompleteAlcoholicCocktailItemList(): Flow<List<AlcoholicCocktailItemDb>>

    @Update
    suspend fun updateAlcoholicCocktailItemDb(alcoholicCocktailItemDb: AlcoholicCocktailItemDb)

    @Query("SELECT * FROM AlcoholicCocktailItemDb WHERE isSaved=1")
    fun getSavedAlcoholicCocktailItemList(): Flow<List<AlcoholicCocktailItemDb>>

}