package app.web.relive.letsgetcocky.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.web.relive.letsgetcocky.data.local.dao.AlcoholicCocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.dao.NonAlcoholicCocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.NonAlcoholicCocktailItemDb


@Database(entities = [(AlcoholicCocktailItemDb::class),
    (NonAlcoholicCocktailItemDb::class)], version = 1, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {
    abstract fun alcoholicCocktailItemDbDao(): AlcoholicCocktailItemDbDao
    abstract fun nonAlcoholicCocktailItemDbDao(): NonAlcoholicCocktailItemDbDao
}