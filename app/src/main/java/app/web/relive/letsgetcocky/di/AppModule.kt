package app.web.relive.letsgetcocky.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import app.web.relive.letsgetcocky.data.local.dao.CocktailDetailsItemDbDao
import app.web.relive.letsgetcocky.data.local.dao.CocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.database.AppDatabase
import app.web.relive.letsgetcocky.data.remote.common.Constants
import app.web.relive.letsgetcocky.data.remote.service.CocktailApi
import app.web.relive.letsgetcocky.data.repository.CocktailRepositoryImpl
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCocktailApi(): CocktailApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CocktailApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "LetsGetCocky.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideCocktailItemDbDao(appDatabase: AppDatabase): CocktailItemDbDao {
        return appDatabase.cocktailItemDbDao()
    }

    @Provides
    @Singleton
    fun provideCocktailRepository(
        cocktailApi: CocktailApi,
        cocktailItemDbDao: CocktailItemDbDao
    ): CocktailRepository {
        return CocktailRepositoryImpl(cocktailApi,cocktailItemDbDao)
    }

}