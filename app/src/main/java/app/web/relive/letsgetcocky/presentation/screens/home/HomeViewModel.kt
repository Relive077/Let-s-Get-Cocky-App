package app.web.relive.letsgetcocky.presentation.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import app.web.relive.letsgetcocky.data.remote.common.Resource
import app.web.relive.letsgetcocky.domain.usecase.GetAlcoholicCocktailListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    private val _selectedTab: MutableState<HomeScreenState> =
        mutableStateOf(HomeScreenState.NON_ALCOHOLIC)
    val selectedTab: State<HomeScreenState> = _selectedTab

    fun selectTab(tab: HomeScreenState) {
        _selectedTab.value = tab
    }

}