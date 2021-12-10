package app.web.relive.letsgetcocky.presentation.screens.save

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.usecase.GetSavedCocktailListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveCocktailListViewModel @Inject constructor(
    private val getSavedCocktailListUseCase: GetSavedCocktailListUseCase
): ViewModel() {

    var savedCocktailList = listOf<CocktailItem>()

    init {
        getSavedCocktailList()
    }

    private fun getSavedCocktailList() {

        viewModelScope.launch {
            getSavedCocktailListUseCase().collect {
                savedCocktailList = it
            }
        }

    }

}