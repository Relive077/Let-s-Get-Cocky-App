package app.web.relive.letsgetcocky.presentation.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.web.relive.letsgetcocky.data.remote.common.Constants
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailDetailsItem
import app.web.relive.letsgetcocky.domain.usecase.GetCocktailDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CocktailDetailsViewModel @Inject constructor(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _cocktailDetailsState = mutableStateOf(CocktailDetailsState())
    val cocktailDetailsState: State<CocktailDetailsState> = _cocktailDetailsState

    init {
        savedStateHandle.get<String>(Constants.QUERY_DRINK_ID)?.let { idDrink ->
            getCocktailDetails(idDrink)
        }
    }

    fun getCocktailDetails(idDrink: String) {
        getCocktailDetailsUseCase(idDrink).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _cocktailDetailsState.value =
                        CocktailDetailsState(data = result.data?:         CocktailDetailsItem("","","","","","",
                            "","","","","","",
                            "","","","","","",
                            "","","","","","",
                            "","","","","","",
                            "","","","")
                        )
                }
                is Resource.Error -> {
                    _cocktailDetailsState.value =
                        CocktailDetailsState(
                            errorMessage = result.message?:"An unexpected Error Occurred"
                        )
                }
                is Resource.Loading -> {
                    _cocktailDetailsState.value =
                        CocktailDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }



}