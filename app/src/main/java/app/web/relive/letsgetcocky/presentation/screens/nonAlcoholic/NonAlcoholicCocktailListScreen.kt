package app.web.relive.letsgetcocky.presentation.screens.nonAlcoholic

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.web.relive.letsgetcocky.R
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem
import app.web.relive.letsgetcocky.presentation.navigation.ScreenRoutes
import app.web.relive.letsgetcocky.presentation.theme.*
import coil.compose.rememberImagePainter
import com.airbnb.lottie.compose.*

@ExperimentalAnimationApi
@Composable
fun NonAlcoholicCocktailListScreen(
    navController: NavController,
    viewModel: NonAlcoholicCocktailListViewModel = hiltViewModel()
) {
    LazyColumn {
        items(viewModel.nonAlcoholicCocktailListState.value.data) {cocktailItem ->
            NonAlcoholicCocktailListItem(
                nonAlcoholicCocktailItem = cocktailItem,
                onSaveNonAlcoholicCocktailItem = { viewModel.saveNonAlcoholicCocktail(cocktailItem) },
                onUnsaveNonAlcoholicCocktailItem = { viewModel.unsaveNonAlcoholicCocktail(cocktailItem) },
                onNonAlcoholicCocktailItemSelected = { navController.navigate(
                    ScreenRoutes.CocktailDetailsScreen.route +
                            "/${cocktailItem.idDrink}") }
            )
        }
    }

    if (viewModel.nonAlcoholicCocktailListState.value.errorMessage.isNotBlank()) {
        LottieWithDesc(
            R.raw.no_internet_connection,
            viewModel.nonAlcoholicCocktailListState.value.errorMessage)
    }
    if (viewModel.nonAlcoholicCocktailListState.value.isLoading) {
        LottieWithDesc(R.raw.loading_beer, "")
    }
}

@ExperimentalAnimationApi
@Composable
fun NonAlcoholicCocktailListItem(
    nonAlcoholicCocktailItem: NonAlcoholicCocktailItem,
    onSaveNonAlcoholicCocktailItem: ()->Unit,
    onUnsaveNonAlcoholicCocktailItem: ()->Unit,
    onNonAlcoholicCocktailItemSelected: ()->Unit
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        backgroundColor = listItemBack,
        modifier = Modifier
            .padding(15.dp)
            .clickable { isExpanded = !isExpanded }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            AnimatedVisibility(visible = isExpanded) {

                Image(painter = rememberImagePainter(nonAlcoholicCocktailItem.strDrinkThumb),
                    contentDescription = nonAlcoholicCocktailItem.strDrink,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                        .height(200.dp)
                        .width(200.dp))

                IconButton(
                    onClick = { onNonAlcoholicCocktailItemSelected() },
                    modifier = Modifier.align(Alignment.CenterVertically)) {

                    Icon(painterResource(id = R.drawable.ic_info),
                        contentDescription = "Info",
                        tint = Color.Cyan
                    )

                }
            }

            IconButton(
                onClick = {
                    if (nonAlcoholicCocktailItem.isSaved) {onUnsaveNonAlcoholicCocktailItem()}
                    else {onSaveNonAlcoholicCocktailItem()}
                          },
                modifier = Modifier.align(Alignment.CenterVertically)) {

                Icon(
                    painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favorite",
                    tint = if(nonAlcoholicCocktailItem.isSaved) favoriteColor else levelThreeDark
                )



            }

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