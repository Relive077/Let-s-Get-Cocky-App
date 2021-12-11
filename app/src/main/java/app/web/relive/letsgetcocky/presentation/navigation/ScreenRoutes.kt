package app.web.relive.letsgetcocky.presentation.navigation

sealed class ScreenRoutes(val route: String) {
    object SplashScreen : ScreenRoutes("splash_screen")
    object HomeScreen: ScreenRoutes("home_screen")
    object AlcoholicCocktailListScreen: ScreenRoutes("alcoholic_cocktail_list_screen")
    object NonAlcoholicCocktailListScreen: ScreenRoutes("non_alcoholic_cocktail_list_screen")
    object SearchCocktailScreen: ScreenRoutes("search_cocktail_screen")
    object SaveCocktailScreen: ScreenRoutes("save_cocktail_screen")
}
