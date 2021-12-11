package app.web.relive.letsgetcocky.di

import android.content.Context
import androidx.room.Room
import app.web.relive.letsgetcocky.data.local.dao.AlcoholicCocktailItemDbDao
import app.web.relive.letsgetcocky.data.local.dao.NonAlcoholicCocktailItemDbDao
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
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context,AppDatabase::class.java,"LetsBeCocky.db")
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideAlcoholicCocktailItemDbDao(appDatabase: AppDatabase): AlcoholicCocktailItemDbDao {
        return appDatabase.alcoholicCocktailItemDbDao()
    }

    @Provides
    @Singleton
    fun provideNonAlcoholicCocktailItemDbDao(appDatabase: AppDatabase): NonAlcoholicCocktailItemDbDao {
        return appDatabase.nonAlcoholicCocktailItemDbDao()
    }

    @Provides
    @Singleton
    fun provideCocktailRepository(
        cocktailApi: CocktailApi,
        alcoholicCocktailItemDbDao: AlcoholicCocktailItemDbDao,
        nonAlcoholicCocktailItemDbDao: NonAlcoholicCocktailItemDbDao
    ): CocktailRepository {
        return CocktailRepositoryImpl(cocktailApi,alcoholicCocktailItemDbDao,nonAlcoholicCocktailItemDbDao)
    }

}