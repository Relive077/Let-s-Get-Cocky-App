package app.web.relive.letsgetcocky.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.web.relive.letsgetcocky.data.local.dao.CocktailDetailsItemDbDao
import app.web.relive.letsgetcocky.data.local.dao.CocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.entity.CocktailDetailsItemDb
import app.web.relive.letsgetcocky.data.local.entity.CocktailItemDb

@Database(
  entities = [(CocktailItemDb::class),(CocktailDetailsItemDb::class)],
  version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
  abstract fun cocktailItemDbDao(): CocktailItemDbDao
  abstract fun cocktailDetailsItemDbDao(): CocktailDetailsItemDbDao
}
