package app.web.relive.letsgetcocky.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import app.web.relive.letsgetcocky.domain.usecase.GetCocktailListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCocktailListUseCase: GetCocktailListUseCase
) : ViewModel() {

    private val _selectedTab: MutableState<HomeScreenState> =
        mutableStateOf(HomeScreenState.NON_ALCOHOLIC)
    val selectedTab: State<HomeScreenState> = _selectedTab

    fun selectTab(tab: HomeScreenState) {
        _selectedTab.value = tab
    }

}