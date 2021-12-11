package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchCocktailUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    operator fun invoke(searchString: String): Flow<Resource<List<CocktailSearchItem>?>> {
        return cocktailRepository.searchCocktail(searchString)
    }


}