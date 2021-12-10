package app.web.relive.letsgetcocky.data.remote.response

import com.google.gson.annotations.SerializedName


data class CocktailSearchListResponse(
    @SerializedName("drinks") val drinks: List<CocktailSearchItemResponse>?
)
