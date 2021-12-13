package app.web.relive.letsgetcocky.presentation.screens.save

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.web.relive.letsgetcocky.domain.model.AlcoholicCocktailItem
import app.web.relive.letsgetcocky.domain.model.NonAlcoholicCocktailItem
import app.web.relive.letsgetcocky.presentation.navigation.ScreenRoutes
import app.web.relive.letsgetcocky.presentation.theme.listItemBack
import coil.compose.rememberImagePainter
import com.airbnb.lottie.compose.*

@ExperimentalAnimationApi
@Composable
fun SaveCocktailScreen(
    navController: NavController,
    viewModel: SaveCocktailViewModel = hiltViewModel()
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(30.dp)

    ) {

        Text(
            text = "Saved Non Alcoholic Cocktails",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp,
            textDecoration = TextDecoration.Underline
            )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.height(200.dp)
        ) {
            items(viewModel.savedNonAlcoholicCocktailListState.value.data) {cocktailItem ->
                SavedNonAlcoholicCocktailListItem(
                    nonAlcoholicCocktailItem = cocktailItem,
                    onSelected = { navController
                        .navigate(ScreenRoutes.CocktailDetailsScreen.route +
                                "/${cocktailItem.idDrink}") },
                    onDeleted = { viewModel.unsaveNonAlcoholicCocktail(cocktailItem) }
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Saved Alcoholic Cocktails",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp,
            textDecoration = TextDecoration.Underline)

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.height(200.dp)
        ) {
            items(viewModel.savedAlcoholicCocktailListState.value.data) {cocktailItem ->
                SavedAlcoholicCocktailListItem(
                    alcoholicCocktailItem = cocktailItem,
                    onSelected = { navController
                        .navigate(ScreenRoutes.CocktailDetailsScreen.route +
                                "/${cocktailItem.idDrink}") },
                    onDeleted = { viewModel.unsaveAlcoholicCocktail(cocktailItem) }
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
    onSelected: ()->Unit,
    onDeleted: ()->Unit
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        backgroundColor = listItemBack,
        modifier = Modifier
            .padding(0.dp,10.dp,0.dp,10.dp)
            .clickable { isExpanded = !isExpanded }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onSelected() }
        ) {

            AnimatedVisibility(visible = isExpanded) {

                Image(painter = rememberImagePainter(alcoholicCocktailItem.strDrinkThumb),
                    contentDescription = alcoholicCocktailItem.strDrink,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                        .height(200.dp)
                        .width(200.dp))
            }


            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp,0.dp,10.dp,0.dp)
                ) {

                Text(text = alcoholicCocktailItem.strDrink,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                IconButton(
                    onClick = { onDeleted() },
                    modifier = Modifier.align(Alignment.CenterVertically)) {

                    Icon(imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Black
                    )

                }

            }

        }
    }
}

@ExperimentalAnimationApi
@Composable
fun SavedNonAlcoholicCocktailListItem(
    nonAlcoholicCocktailItem: NonAlcoholicCocktailItem,
    onSelected: ()->Unit,
    onDeleted: ()->Unit
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        backgroundColor = listItemBack,
        modifier = Modifier
            .padding(0.dp,10.dp,0.dp,10.dp)
            .clickable { isExpanded = !isExpanded }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onSelected() }
        ) {

            AnimatedVisibility(visible = isExpanded) {

                Image(painter = rememberImagePainter(nonAlcoholicCocktailItem.strDrinkThumb),
                    contentDescription = nonAlcoholicCocktailItem.strDrink,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                        .height(200.dp)
                        .width(200.dp))
            }


            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp,0.dp,10.dp,0.dp)
            ) {

                Text(text = nonAlcoholicCocktailItem.strDrink,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                IconButton(
                    onClick = { onDeleted() },
                    modifier = Modifier.align(Alignment.CenterVertically)) {

                    Icon(imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Black
                    )

                }

            }

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

