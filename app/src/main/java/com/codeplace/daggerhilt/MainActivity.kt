package com.codeplace.daggerhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.daggerhilt.presentation.home.HomeScreen
import com.codeplace.daggerhilt.presentation.home.HomeScreenViewModel
import com.codeplace.daggerhilt.ui.theme.DaggerHiltTheme
import dagger.hilt.android.AndroidEntryPoint


/** @AndroidEntryPoint
 * This annotation is needed, because we injected the dependency
 * val viewModel = hiltViewModel<HomeScreenViewModel>(), in an android component class,
 * android component class would be things that come from the android framework, as activity, fragment...
 * So to inject the dependency inside the viewmodel, we need this annotation.
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel = hiltViewModel<HomeScreenViewModel>()
                    val state = viewModel.isLoading
                    HomeScreen(uiState = state)
                }
            }
        }
    }
}

