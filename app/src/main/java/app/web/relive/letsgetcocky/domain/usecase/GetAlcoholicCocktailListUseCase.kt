package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAlcoholicCocktailListUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    operator fun invoke(): Flow<Resource<List<AlcoholicCocktailItem>>> {
        return cocktailRepository.getAlcoholicCocktailList()
    }


}