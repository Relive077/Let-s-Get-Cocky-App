package app.web.relive.letsgetcocky.domain.usecase

import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SaveCocktailItemUseCase @Inject constructor(
    private val cocktailRepository: CocktailRepository
) {

    suspend operator fun invoke(cocktailItem: CocktailItem) {
        cocktailRepository.saveCocktailItem(cocktailItem)
    }

}