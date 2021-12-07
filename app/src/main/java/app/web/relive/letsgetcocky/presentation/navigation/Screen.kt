package app.web.relive.letsgetcocky.presentation.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object AlcoholicCocktailListScreen : Screen("alcoholic_cocktail_list_screen")
    object NonAlcoholicCocktailListScreen : Screen("non_alcoholic_cocktail_list_screen")
    object CocktailSearchScreen : Screen("cocktail_search_screen")
}
