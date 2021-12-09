package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailDetailedItem
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCocktailDetailedUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    operator fun invoke(searchString: String): Flow<Resource<List<CocktailDetailedItem>>> = flow {

        try {
            emit(Resource.Loading<List<CocktailDetailedItem>>())
            val cocktailDetailedList = cocktailRepository.getCocktailDetailedList(searchString)
            emit(Resource.Success<List<CocktailDetailedItem>>(cocktailDetailedList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CocktailDetailedItem>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<CocktailDetailedItem>>("Couldn't reach server. Check your internet connection."))
        }
    }


}