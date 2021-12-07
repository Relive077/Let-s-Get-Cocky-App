package app.web.relive.letsgetcocky.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.web.relive.letsgetcocky.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = true) {

        delay(3000L)
        navController.popBackStack()
        navController.navigate("main_screen")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        val lottieCompositionResult: LottieCompositionResult =
            rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))

        val progress by animateLottieCompositionAsState(
            lottieCompositionResult.value,
            isPlaying = true,
            iterations = LottieConstants.IterateForever,
            speed = 1.0f
        )

        LottieAnimation(
            composition = lottieCompositionResult.value,
            progress = progress,
            modifier = Modifier.padding(all = 30.dp)
        )
    }
}
