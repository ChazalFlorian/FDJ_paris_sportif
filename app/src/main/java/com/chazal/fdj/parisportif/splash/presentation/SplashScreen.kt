package com.chazal.fdj.parisportif.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.chazal.fdj.parisportif.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    goToNext: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        delay(500)
        goToNext()
    }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(goToNext = {})
}