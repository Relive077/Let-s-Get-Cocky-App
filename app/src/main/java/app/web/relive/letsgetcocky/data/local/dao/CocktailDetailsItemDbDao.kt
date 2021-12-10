package app.web.relive.letsgetcocky.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.web.relive.letsgetcocky.data.local.entity.CocktailDetailsItemDb
import app.web.relive.letsgetcocky.data.local.entity.CocktailItemDb

@Dao
interface CocktailDetailsItemDbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCocktailDetailsItemDb(cocktailDetailsItemDb: CocktailDetailsItemDb)

    @Query("SELECT * FROM CocktailDetailsItemDb")
    suspend fun getAllCocktailDetailsItems(): List<CocktailDetailsItemDb>
}