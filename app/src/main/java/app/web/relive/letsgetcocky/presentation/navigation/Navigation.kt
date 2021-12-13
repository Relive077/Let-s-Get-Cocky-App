package app.web.relive.letsgetcocky.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.AlcoholicCocktailListScreen
import app.web.relive.letsgetcocky.presentation.screens.detail.CocktailDetailsScreen
import app.web.relive.letsgetcocky.presentation.screens.home.HomeScreen
import app.web.relive.letsgetcocky.presentation.screens.nonAlcoholic.NonAlcoholicCocktailListScreen
import app.web.relive.letsgetcocky.presentation.screens.save.SaveCocktailScreen
import app.web.relive.letsgetcocky.presentation.screens.search.SearchCocktailScreen
import app.web.relive.letsgetcocky.presentation.screens.splash.SplashScreen

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.SplashScreen.route
    ) {
        composable(
            route = ScreenRoutes.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
        composable(
            route = ScreenRoutes.HomeScreen.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = ScreenRoutes.AlcoholicCocktailListScreen.route
        ) {
            AlcoholicCocktailListScreen(navController)
        }
        composable(
            route = ScreenRoutes.NonAlcoholicCocktailListScreen.route
        ) {
            NonAlcoholicCocktailListScreen(navController)
        }
        composable(
            route = ScreenRoutes.SearchCocktailScreen.route
        ) {
            SearchCocktailScreen()
        }
        composable(
            route = ScreenRoutes.SaveCocktailScreen.route
        ) {
            SaveCocktailScreen(navController)
        }
        composable(
            route = ScreenRoutes.CocktailDetailsScreen.route + "/{idDrink}"
        ) {
            CocktailDetailsScreen()
        }


    }
}