package app.web.relive.letsgetcocky.data.remote.service

import app.web.relive.letsgetcocky.data.remote.response.CocktailListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("/api/json/v1/1/filter.php")
    suspend fun getCocktailList(
        @Query("a") drinkType: String
    ): CocktailListResponse


}