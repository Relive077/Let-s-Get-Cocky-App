package app.web.relive.letsgetcocky.presentation.screens.save

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem
import app.web.relive.letsgetcocky.presentation.navigation.ScreenRoutes
import app.web.relive.letsgetcocky.presentation.screens.alcoholic.AlcoholicCocktailListViewModel
import app.web.relive.letsgetcocky.presentation.theme.favoriteColor
import app.web.relive.letsgetcocky.presentation.theme.levelThreeDark
import app.web.relive.letsgetcocky.presentation.theme.listItemBack
import coil.compose.rememberImagePainter
import com.airbnb.lottie.compose.*

@ExperimentalAnimationApi
@Composable
fun SaveCocktailScreen(
    viewModel: SaveCocktailViewModel = hiltViewModel()
) {
    Column() {

        Text(text = "Saved Non Alcoholic Cocktails")

        LazyRow {
            items(viewModel.savedNonAlcoholicCocktailListState.value.data) {cocktailItem ->
                SavedNonAlcoholicCocktailListItem(
                    nonAlcoholicCocktailItem = cocktailItem,
                )
            }
        }

        Text(text = "Saved Alcoholic Cocktails")

        LazyRow {
            items(viewModel.savedAlcoholicCocktailListState.value.data) {cocktailItem ->
                SavedAlcoholicCocktailListItem(
                    alcoholicCocktailItem = cocktailItem,
                )
            }
        }

    }

    if (viewModel.savedNonAlcoholicCocktailListState.value.errorMessage.isNotBlank()) {
        LottieWithDesc(
            app.web.relive.letsgetcocky.R.raw.no_internet_connection,
            viewModel.savedNonAlcoholicCocktailListState.value.errorMessage)
    }
    if (viewModel.savedNonAlcoholicCocktailListState.value.isLoading) {
        LottieWithDesc(app.web.relive.letsgetcocky.R.raw.loading_beer, "")
    }
}

@ExperimentalAnimationApi
@Composable
fun SavedAlcoholicCocktailListItem(
    alcoholicCocktailItem: AlcoholicCocktailItem,
) {

    Card(
        backgroundColor = listItemBack,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp, 0.dp, 50.dp, 0.dp))
            .padding(15.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Text(text = alcoholicCocktailItem.strDrink,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )

        }
    }
}

@ExperimentalAnimationApi
@Composable
fun SavedNonAlcoholicCocktailListItem(
    nonAlcoholicCocktailItem: NonAlcoholicCocktailItem,
) {

    Card(
        backgroundColor = listItemBack,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp, 0.dp, 50.dp, 0.dp))
            .padding(15.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Text(text = nonAlcoholicCocktailItem.strDrink,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 15.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
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

