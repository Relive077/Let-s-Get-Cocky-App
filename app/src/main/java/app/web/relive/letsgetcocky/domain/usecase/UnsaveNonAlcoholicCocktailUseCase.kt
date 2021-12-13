package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.local.entity.NonAlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsaveNonAlcoholicCocktailUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    suspend operator fun invoke(nonAlcoholicCocktailItem: NonAlcoholicCocktailItem) {
        val updatedNonAlcoholicCocktailItemDb: NonAlcoholicCocktailItemDb = NonAlcoholicCocktailItemDb(
            strDrink = nonAlcoholicCocktailItem.strDrink,
            strDrinkThumb = nonAlcoholicCocktailItem.strDrinkThumb,
            idDrink = nonAlcoholicCocktailItem.idDrink,
            isSaved = false
        )
        cocktailRepository.updateNonAlcoholicCocktailItemAsFavorite(updatedNonAlcoholicCocktailItemDb)
    }


}