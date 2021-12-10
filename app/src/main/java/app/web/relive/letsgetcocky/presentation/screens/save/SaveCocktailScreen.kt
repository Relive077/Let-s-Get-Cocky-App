package app.web.relive.letsgetcocky.presentation.screens.save

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
import androidx.navigation.NavController
import app.web.relive.letsgetcocky.R
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.domain.model.CocktailSearchItem
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.AlcoholicCocktailListItem
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.LottieWithDesc
import app.web.relive.letsgetcocky.presentation.screens.search.SearchCocktailViewModel
import app.web.relive.letsgetcocky.presentation.theme.listItemBack
import coil.compose.rememberImagePainter

@Composable
fun SaveCocktailScreen(
    viewModel: SaveCocktailListViewModel = hiltViewModel()
) {


    Column() {

        LazyColumn() {
            items(viewModel.savedCocktailList) {
                SavedCocktailItem(
                    savedCocktailItem = it
                )
            }
        }

    }

}

@Composable
fun SavedCocktailItem(
    savedCocktailItem: CocktailItem
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

            Image(painter = rememberImagePainter(savedCocktailItem.strDrinkThumb),
                contentDescription = savedCocktailItem.strDrink,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp,20.dp,20.dp,20.dp))
                    .height(200.dp)
                    .width(200.dp))

            Text(text = savedCocktailItem.strDrink,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
                    .padding(20.dp)
            )
        }
    }
}
