package app.web.relive.letsgetcocky.presentation.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.web.relive.letsgetcocky.R
import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.LottieWithDesc
import app.web.relive.letsgetcocky.presentation.theme.listItemBack
import coil.compose.rememberImagePainter

@Composable
fun SearchCocktailScreen(
    viewModel: SearchCocktailViewModel = hiltViewModel()
) {

    val searchWidgetTextState by viewModel.searchWidgetTextState

    Column() {
        
        SearchAppBar(searchText = searchWidgetTextState,
            onSearchTextChange = {
                viewModel.updateSearchWidgetTextState(it)
            })

        LazyColumn() {
            items(viewModel.searchCocktailListState.value.data) { cocktailDetailedItem ->
                CocktailDetailedItem(cocktailSearchItem = cocktailDetailedItem)
            }
        }

        if (viewModel.searchCocktailListState.value.errorMessage.isNotBlank()) {
            LottieWithDesc(
                R.raw.no_internet_connection,
                viewModel.searchCocktailListState.value.errorMessage)
        }
        if (viewModel.searchCocktailListState.value.isLoading) {
            LottieWithDesc(R.raw.loading_beer, "")
        }

    }

}

@Composable
fun CocktailDetailedItem(
    cocktailSearchItem: CocktailSearchItem
) {
    Card(
        backgroundColor = listItemBack,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp,0.dp,50.dp,0.dp))
            .padding(15.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Image(painter = rememberImagePainter(cocktailSearchItem.strDrinkThumb),
                contentDescription = cocktailSearchItem.strDrink,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp,20.dp,20.dp,20.dp))
                    .height(200.dp)
                    .width(200.dp))

            Text(text = cocktailSearchItem.strDrink,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
                    .padding(20.dp)
            )
        }
    }
}



@Composable
fun SearchAppBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = searchText,
        onValueChange = {
            onSearchTextChange(it)
        },
        placeholder = {
            Text(
                modifier = Modifier
                    .alpha(ContentAlpha.medium),
                text = "Search here...",
                color = Color.White
            )
        },
        textStyle = TextStyle(
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        ),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Color.White.copy(alpha = ContentAlpha.medium),
            textColor = Color.White
        )
    )

}