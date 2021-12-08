package app.web.relive.letsgetcocky.presentation.screens.alcoholic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.web.relive.letsgetcocky.domain.model.CocktailItem
import app.web.relive.letsgetcocky.presentation.theme.listItemBack
import coil.compose.rememberImagePainter
import com.airbnb.lottie.compose.*

@Composable
fun AlcoholicCocktailListScreen(
    viewModel: AlcoholicCocktailListViewModel = hiltViewModel()
) {
    LazyColumn() {
        items(viewModel.alcoholicCocktailListState.value.data) {cocktailItem ->
            AlcoholicCocktailListItem(cocktailItem = cocktailItem)
        }
    }

    if (viewModel.alcoholicCocktailListState.value.errorMessage.isNotBlank()) {
        LottieWithDesc(app.web.relive.letsgetcocky.R.raw.no_internet_connection,
            viewModel.alcoholicCocktailListState.value.errorMessage)
    }
    if (viewModel.alcoholicCocktailListState.value.isLoading) {
        LottieWithDesc(app.web.relive.letsgetcocky.R.raw.loading_beer, "")
    }
}

@Composable
fun AlcoholicCocktailListItem(
    cocktailItem: CocktailItem
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
            
            Image(painter = rememberImagePainter(cocktailItem.strDrinkThumb),
                contentDescription = cocktailItem.strDrink,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp,20.dp,20.dp,20.dp))
                .height(200.dp)
                .width(200.dp))

            Text(text = cocktailItem.strDrink,
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
fun LottieWithDesc(
    lottie: Int,
    message: String?
) {
    val lottieCompositionResult: LottieCompositionResult =
        rememberLottieComposition(LottieCompositionSpec.RawRes(lottie))

    val progress by animateLottieCompositionAsState(
        lottieCompositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            LottieAnimation(
                composition = lottieCompositionResult.value,
                progress = progress,
                modifier = Modifier
                    .height(200.dp),
                alignment = Alignment.Center
            )

            if (message != null) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = message,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
