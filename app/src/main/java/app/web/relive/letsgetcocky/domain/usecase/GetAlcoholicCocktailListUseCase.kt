package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAlcoholicCocktailListUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    operator fun invoke(): Flow<Resource<List<CocktailItem>>> = flow {

        try {
            emit(Resource.Loading<List<CocktailItem>>())
            val cocktails = cocktailRepository.getCocktailList("Alcoholic")
            emit(Resource.Success<List<CocktailItem>>(cocktails))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CocktailItem>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<CocktailItem>>("Couldn't reach server. Check your internet connection."))
        }
    }


}