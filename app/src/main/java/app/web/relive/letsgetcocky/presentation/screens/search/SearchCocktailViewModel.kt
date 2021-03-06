package app.web.relive.letsgetcocky.presentation.screens.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.usecase.SearchCocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchCocktailViewModel @Inject constructor(
    private val searchCocktailUseCase: SearchCocktailUseCase
): ViewModel() {

    ///////////////////////////////////// Search Text /////////////////////////////////////////////////

    private val _searchWidgetTextState: MutableState<String> = mutableStateOf("")
    val searchWidgetTextState: State<String> = _searchWidgetTextState

    fun updateSearchWidgetTextState(newSearchWidgetTextState: String) {
        _searchWidgetTextState.value = newSearchWidgetTextState

        if (_searchWidgetTextState.value.length>=3) {
            getCocktailDetailedList(_searchWidgetTextState.value)
        }
    }

    //////////////////////////////// Cocktail Detailed List ///////////////////////////////////////////

    private val _cocktailDetailedListState = mutableStateOf(SearchCocktailListState())
    val searchCocktailListState: State<SearchCocktailListState> = _cocktailDetailedListState

    fun getCocktailDetailedList(searchString: String) {
        searchCocktailUseCase(searchString).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _cocktailDetailedListState.value = SearchCocktailListState(data = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _cocktailDetailedListState.value =
                        SearchCocktailListState(errorMessage = result.message?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _cocktailDetailedListState.value =
                        SearchCocktailListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}