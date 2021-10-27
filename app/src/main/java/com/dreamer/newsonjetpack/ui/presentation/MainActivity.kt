package com.dreamer.newsonjetpack.ui.presentation

import android.graphics.Color.WHITE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dreamer.newsonjetpack.R
import com.dreamer.newsonjetpack.ui.presentation.viewmodel.detail.DetailsScreen
import com.dreamer.newsonjetpack.ui.presentation.viewmodel.list.ListScreen1
import com.dreamer.newsonjetpack.ui.presentation.viewmodel.search.SearchScreen
import com.dreamer.newsonjetpack.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint


object Destinations {
    const val LIST_SCREEN = "LIST_SCREEN"
    const val DETAILS_SCREEN = "DETAILS_SCREEN"
    const val SEARCH_SCREEN = "SEARCH_SCREEN"
}

var searchCountry: String = "RU"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @SuppressLint("MissingPermission")
//    private fun isNetworkConnected(): Boolean {
//        val cm = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
//        return cm.activeNetworkInfo != null
//    }

    @ExperimentalAnimationApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val windows = this.window
        windows.statusBarColor = WHITE
//        val nc = isNetworkConnected()
//        val ping = internetIsConnected()
//        Log.e("TAG",nc.toString())
//        Log.e("TAG",ping.toString())
//        if (ping == true) {
//            Toast.makeText(this,ping.toString(),Toast.LENGTH_LONG).show()

        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                        SearchEnter()
//                        CircularButton(R.drawable.ic_launcher_background)
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.LIST_SCREEN,
                    ) {
                        composable(Destinations.LIST_SCREEN) {
                            ListScreen1(navController)
                        }
                        composable("${Destinations.DETAILS_SCREEN}/{newTitle}") {
                            it.arguments?.getString("newTitle")?.let { title ->
                                DetailsScreen(title, navController)
                            }
                        }
                        composable(Destinations.SEARCH_SCREEN) {
                            SearchScreen(navController)
                        }
                    }
                }
            }
        }
//        }
//            else {
////            Greeting("LLLLLLLLO")
//            Toast.makeText(this,ping.toString(),Toast.LENGTH_LONG).show()
//        }
    }

}

@Composable
fun CircularButton(
    @DrawableRes iconResouce: Int,
    color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResouce), null)
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchEnter() {
//    Scaffold() {


    Column(

        Modifier
            .padding(8.dp)
            .fillMaxWidth()


    )

    {
        /// experimental API on jetpack - ahtung!!!!!
        val keyboardController = LocalSoftwareKeyboardController.current
        var textOfSearch by remember { mutableStateOf("RU") }


        searchCountry = textOfSearch

        OutlinedTextField(
            value = textOfSearch,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
//                            onDone = { navController.popBackStack() }
                onDone = { keyboardController?.hide() }
            ),
            onValueChange = { textOfSearch = it },
            label = {
                Text(
                    stringResource(R.string.serchscreenLabel),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
//}