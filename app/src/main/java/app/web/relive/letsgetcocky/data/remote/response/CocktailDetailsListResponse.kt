package app.web.relive.letsgetcocky.data.remote.response

import com.google.gson.annotations.SerializedName


data class CocktailDetailsListResponse(
    @SerializedName("drinks") val drinks: List<CocktailDetailsItemResponse>
)
