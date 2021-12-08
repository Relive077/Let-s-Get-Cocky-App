package app.web.relive.letsgetcocky.data.remote.response

import com.google.gson.annotations.SerializedName


data class CocktailListResponse(
    @SerializedName("drinks") val drinks: List<CocktailItemResponse>
)
