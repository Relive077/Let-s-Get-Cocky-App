package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.CocktailDetailsItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCocktailDetailsUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    operator fun invoke(idDrink: String): Flow<Resource<CocktailDetailsItem>> {
        return cocktailRepository.getCocktailDetails(idDrink)
    }


}