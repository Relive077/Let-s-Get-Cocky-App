package app.web.relive.letsgetcocky.presentation.screens.nonAlcoholic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.usecase.GetAlcoholicCocktailListUseCase
import app.web.relive.letsgetcocky.domain.usecase.GetNonAlcoholicCocktailListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicCocktailListViewModel @Inject constructor(
    private val getNonAlcoholicCocktailListUseCase: GetNonAlcoholicCocktailListUseCase
): ViewModel() {

    private val _nonAlcoholicCocktailListState = mutableStateOf(NonAlcoholicCocktailListState())
    val nonAlcoholicCocktailListState: State<NonAlcoholicCocktailListState> = _nonAlcoholicCocktailListState

    init {
        getNonAlcoholicCocktailList()
    }

    private fun getNonAlcoholicCocktailList() {
        getNonAlcoholicCocktailListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _nonAlcoholicCocktailListState.value = NonAlcoholicCocktailListState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _nonAlcoholicCocktailListState.value =
                        NonAlcoholicCocktailListState(errorMessage = result.message?:"An unexpected Error Occurred")
                }
                is Resource.Loading -> {
                    _nonAlcoholicCocktailListState.value =
                        NonAlcoholicCocktailListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}