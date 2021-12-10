package app.web.relive.letsgetcocky.data.remote.service

import app.web.relive.letsgetcocky.data.remote.response.CocktailSearchListResponse
import app.web.relive.letsgetcocky.data.remote.response.CocktailDetailsResponseList
import app.web.relive.letsgetcocky.data.remote.response.CocktailListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("/api/json/v1/1/filter.php")
    suspend fun getCocktailList(
        @Query("a") drinkType: String
    ): CocktailListResponse

    @GET("/api/json/v1/1/search.php")
    suspend fun getCocktailListBySearch(
        @Query("s") searchString: String
    ): CocktailSearchListResponse

    @GET("/api/json/v1/1/lookup.php")
    suspend fun getCocktailDetailsById(
        @Query("i") drinkId: String
    ): CocktailDetailsResponseList


}