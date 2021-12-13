package app.web.relive.letsgetcocky.presentation.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.web.relive.letsgetcocky.domain.model.CocktailDetailsItem
import app.web.relive.letsgetcocky.presentation.theme.Gray900
import app.web.relive.letsgetcocky.presentation.theme.levelThreeDark
import app.web.relive.letsgetcocky.presentation.theme.listItemBack
import app.web.relive.letsgetcocky.presentation.theme.textColor
import coil.compose.rememberImagePainter

@Composable
fun CocktailDetailsScreen(
    viewModel: CocktailDetailsViewModel = hiltViewModel()
) {
    val cocktailDetailsItem: CocktailDetailsItem = viewModel.cocktailDetailsState.value.data
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(levelThreeDark)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(listItemBack)
                .padding(30.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = cocktailDetailsItem.strDrink,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = rememberImagePainter(cocktailDetailsItem.strDrinkThumb),
                contentDescription = "Cocktail Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                    .height(200.dp)
                    .width(200.dp))
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Instructions",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = textColor,
                fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = cocktailDetailsItem.strInstructions ?: "",
                fontSize = 15.sp,
                lineHeight = 35.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Ingredients",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = textColor,
                fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            if(cocktailDetailsItem.strIngredient1!=null && cocktailDetailsItem.strMeasure1!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient1,cocktailDetailsItem.strMeasure1)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient2!=null && cocktailDetailsItem.strMeasure2!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient2,cocktailDetailsItem.strMeasure2)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient3!=null && cocktailDetailsItem.strMeasure3!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient3,cocktailDetailsItem.strMeasure3)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient4!=null && cocktailDetailsItem.strMeasure4!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient4,cocktailDetailsItem.strMeasure4)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient5!=null && cocktailDetailsItem.strMeasure5!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient5,cocktailDetailsItem.strMeasure5)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient6!=null && cocktailDetailsItem.strMeasure6!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient6,cocktailDetailsItem.strMeasure6)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient7!=null && cocktailDetailsItem.strMeasure7!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient7,cocktailDetailsItem.strMeasure7)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient8!=null && cocktailDetailsItem.strMeasure8!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient8,cocktailDetailsItem.strMeasure8)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient9!=null && cocktailDetailsItem.strMeasure9!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient9,cocktailDetailsItem.strMeasure9)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient10!=null && cocktailDetailsItem.strMeasure10!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient10,cocktailDetailsItem.strMeasure10)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient11!=null && cocktailDetailsItem.strMeasure11!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient11,cocktailDetailsItem.strMeasure11)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient12!=null && cocktailDetailsItem.strMeasure12!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient12,cocktailDetailsItem.strMeasure12)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient13!=null && cocktailDetailsItem.strMeasure13!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient13,cocktailDetailsItem.strMeasure13)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient14!=null && cocktailDetailsItem.strMeasure14!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient14,cocktailDetailsItem.strMeasure14)}
            Spacer(modifier = Modifier.height(5.dp))
            if(cocktailDetailsItem.strIngredient15!=null && cocktailDetailsItem.strMeasure15!=null)
            {IngredientComponent(cocktailDetailsItem.strIngredient15,cocktailDetailsItem.strMeasure15)}
        }

    }
}

@Composable
fun IngredientComponent(
    ingredientName: String,
    ingredientQuant: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "$ingredientName:",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold)
        Text(text = ingredientQuant,fontSize = 15.sp)
    }

}