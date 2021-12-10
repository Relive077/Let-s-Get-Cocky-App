package app.web.relive.letsgetcocky.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.web.relive.letsgetcocky.data.local.entity.CocktailItemDb
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailItemDbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailItemDb(cocktailItemDb: CocktailItemDb)

    @Query("SELECT * FROM CocktailItemDb")
    fun getAllCocktailItems(): Flow<List<CocktailItemDb>>

    @Query("DELETE FROM CocktailItemDb WHERE idDrink = :idDrink")
    suspend fun deleteCocktailItemDb(idDrink: String)
}