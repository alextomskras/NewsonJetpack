package com.dreamer.newsonjetpack.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dreamer.newsonjetpack.ui.presentation.viewmodel.DetailsScreen
import com.dreamer.newsonjetpack.ui.presentation.viewmodel.ListScreen
import com.dreamer.newsonjetpack.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

object Destinations {
    const val LIST_SCREEN = "LIST_SCREEN"
    const val DETAILS_SCREEN = "DETAILS_SCREEN"
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.LIST_SCREEN,
                    ) {
                        composable(Destinations.LIST_SCREEN) {
                            ListScreen(navController)
                        }
                        composable("${Destinations.DETAILS_SCREEN}/{newTitle}") {
                            it.arguments?.getString("newTitle")?.let { title ->
                                DetailsScreen(title, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NewsAppTheme {
//        Greeting("Android")
//    }
//}