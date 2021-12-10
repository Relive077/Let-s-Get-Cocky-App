package app.web.relive.letsgetcocky.presentation.screens.home

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.AlcoholicCocktailListScreen
import app.web.relive.letsgetcocky.presentation.screens.nonAlcoholic.NonAlcoholicCocktailListScreen
import app.web.relive.letsgetcocky.presentation.screens.save.SaveCocktailScreen
import app.web.relive.letsgetcocky.presentation.screens.search.SearchCocktailScreen
import app.web.relive.letsgetcocky.presentation.theme.*
import app.web.relive.letsgetcocky.presentation.theme.Gray900

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun HomeScreen() {

   val homeViewModel = HomeViewModel()
   val selectedTab by homeViewModel.selectedTab
   val tabs = HomeScreenState.values()

   Scaffold(
      backgroundColor = levelThreeDark,
      bottomBar = {
         BottomNavigation(
            backgroundColor = levelTwoDark,
            modifier = Modifier
               .clip(RoundedCornerShape(10.dp, 10.dp))
               .fillMaxWidth()
               .height(56.dp)
         ) {
            tabs.forEach { tab ->
               BottomNavigationItem(
                  icon = {
                     Icon(painter = painterResource(tab.icon),
                     contentDescription = stringResource(tab.title)
                     )
                  },
                  label = { Text(text = stringResource(tab.title)) },
                  selected = tab == selectedTab,
                  onClick = { homeViewModel.selectTab(tab) },
                  selectedContentColor = levelOneDark,
                  unselectedContentColor = notSelectedDark,
               )
            }
         }
      }
   ) { innerPadding ->
      val modifier = Modifier.padding(innerPadding)

      Crossfade(selectedTab) { destination ->
         when (destination) {
            HomeScreenState.NON_ALCOHOLIC -> NonAlcoholicCocktailListScreen()
            HomeScreenState.ALCOHOLIC -> AlcoholicCocktailListScreen()
            HomeScreenState.SEARCH -> SearchCocktailScreen()
            HomeScreenState.SAVE -> SaveCocktailScreen()

         }
      }

   }



}