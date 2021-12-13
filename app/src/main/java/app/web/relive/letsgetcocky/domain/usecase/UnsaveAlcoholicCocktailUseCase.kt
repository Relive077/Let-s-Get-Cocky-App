package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.local.entity.AlcoholicCocktailItemDb
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsaveAlcoholicCocktailUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    suspend operator fun invoke(alcoholicCocktailItem: AlcoholicCocktailItem) {
        val updatedAlcoholicCocktailItemDb: AlcoholicCocktailItemDb = AlcoholicCocktailItemDb(
            strDrink = alcoholicCocktailItem.strDrink,
            strDrinkThumb = alcoholicCocktailItem.strDrinkThumb,
            idDrink = alcoholicCocktailItem.idDrink,
            isSaved = false
        )
        cocktailRepository.updateAlcoholicCocktailItemAsFavorite(updatedAlcoholicCocktailItemDb)
    }


}