package app.web.relive.letsgetcocky.presentation.screens.save

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.usecase.GetAlcoholicCocktailListUseCase
import app.web.relive.letsgetcocky.domain.usecase.GetSavedAlcoholicCocktailListUseCase
import app.web.relive.letsgetcocky.domain.usecase.GetSavedNonAlcoholicCocktailListUseCase
import app.web.relive.letsgetcocky.domain.usecase.UpdateAlcoholicCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveCocktailViewModel @Inject constructor(
    private val getSavedAlcoholicCocktailListUseCase: GetSavedAlcoholicCocktailListUseCase,
    private val getSavedNonAlcoholicCocktailListUseCase: GetSavedNonAlcoholicCocktailListUseCase
): ViewModel() {

    private val _savedAlcoholicCocktailListState = mutableStateOf(SavedAlcoholicCocktailListState())
    val savedAlcoholicCocktailListState: State<SavedAlcoholicCocktailListState>
        = _savedAlcoholicCocktailListState

    private val _savedNonAlcoholicCocktailListState = mutableStateOf(SavedNonAlcoholicCocktailListState())
    val savedNonAlcoholicCocktailListState: State<SavedNonAlcoholicCocktailListState>
            = _savedNonAlcoholicCocktailListState

    init {
        getSavedAlcoholicCocktailList()
        getSavedNonAlcoholicCocktailList()
    }

    private fun getSavedAlcoholicCocktailList() {
        getSavedAlcoholicCocktailListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _savedAlcoholicCocktailListState.value =
                        SavedAlcoholicCocktailListState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _savedAlcoholicCocktailListState.value =
                        SavedAlcoholicCocktailListState(
                            errorMessage = result.message?:"An unexpected Error Occurred")
                }
                is Resource.Loading -> {
                    _savedAlcoholicCocktailListState.value =
                        SavedAlcoholicCocktailListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getSavedNonAlcoholicCocktailList() {
        getSavedNonAlcoholicCocktailListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _savedNonAlcoholicCocktailListState.value =
                        SavedNonAlcoholicCocktailListState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _savedNonAlcoholicCocktailListState.value =
                        SavedNonAlcoholicCocktailListState(
                            errorMessage = result.message?:"An unexpected Error Occurred")
                }
                is Resource.Loading -> {
                    _savedNonAlcoholicCocktailListState.value =
                        SavedNonAlcoholicCocktailListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }



}