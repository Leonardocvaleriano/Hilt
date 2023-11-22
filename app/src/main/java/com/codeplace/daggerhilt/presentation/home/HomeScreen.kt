package com.codeplace.daggerhilt.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.daggerhilt.ui.theme.DaggerHiltTheme

@Composable
fun HomeScreen(uiState:HomeState) {

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Text(text = uiState.isLoading.toString())

        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerHiltTheme {
//        HomeScreen()
    }
}
