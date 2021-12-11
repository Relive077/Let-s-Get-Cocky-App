package app.web.relive.letsgetcocky.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.AlcoholicCocktailListScreen
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
            HomeScreen()
        }
        composable(
            route = ScreenRoutes.AlcoholicCocktailListScreen.route
        ) {
            AlcoholicCocktailListScreen()
        }
        composable(
            route = ScreenRoutes.NonAlcoholicCocktailListScreen.route
        ) {
            NonAlcoholicCocktailListScreen()
        }
        composable(
            route = ScreenRoutes.SearchCocktailScreen.route
        ) {
            SearchCocktailScreen()
        }
        composable(
            route = ScreenRoutes.SaveCocktailScreen.route
        ) {
            SaveCocktailScreen()
        }


    }
}