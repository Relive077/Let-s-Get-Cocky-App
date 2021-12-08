package app.web.relive.letsgetcocky.presentation.screens.alcoholic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.usecase.GetAlcoholicCocktailListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlcoholicCocktailListViewModel @Inject constructor(
    private val getAlcoholicCocktailListUseCase: GetAlcoholicCocktailListUseCase
): ViewModel() {

    private val _alcoholicCocktailListState = mutableStateOf(AlcoholicCocktailListState())
    val alcoholicCocktailListState: State<AlcoholicCocktailListState> = _alcoholicCocktailListState

    init {
        getAlcoholicCocktailList()
    }

    private fun getAlcoholicCocktailList() {
        getAlcoholicCocktailListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _alcoholicCocktailListState.value = AlcoholicCocktailListState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _alcoholicCocktailListState.value =
                        AlcoholicCocktailListState(errorMessage = result.message?:"An unexpected Error Occurred")
                }
                is Resource.Loading -> {
                    _alcoholicCocktailListState.value =
                        AlcoholicCocktailListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}