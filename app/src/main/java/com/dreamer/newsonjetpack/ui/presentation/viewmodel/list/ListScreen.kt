package com.dreamer.newsonjetpack.ui.presentation.viewmodel.list

//import com.dreamer.newsonjetpack.Destinations


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.dreamer.newsonjetpack.R
import com.dreamer.newsonjetpack.model.News
import com.dreamer.newsonjetpack.ui.presentation.Destinations
import com.dreamer.newsonjetpack.ui.presentation.searchCountry
import com.dreamer.newsonjetpack.ui.theme.NewsAppTheme

//object Destinations {
//    const val LIST_SCREEN = "LIST_SCREEN"
//    const val DETAILS_SCREEN = "DETAILS_SCREEN"
//    const val SEARCH_SCREEN = "SEARCH_SCREEN"
//}

@ExperimentalComposeUiApi
@Composable
fun ListScreen1(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val newsList by viewModel.getNews().observeAsState(initial = emptyList())
//    StartSearch(navController, newsList)
    ListScreen(navController, newsList)
//    imageVector = Icons.Filled.ArrowBack

}

@ExperimentalComposeUiApi
@Composable
fun StartSearch(
    navController: NavController,
    newsList: List<News>
) {


    Box(

        Modifier
            .padding(8.dp)
            .fillMaxWidth()


    )

    {
//        SearchEnter(navController)
//        CircularButton(R.drawable.ic_launcher_background)
        ListScreen(navController, newsList)

    }
    Spacer(modifier = Modifier.padding(32.dp))
    Box(

        Modifier
            .padding(8.dp)
            .fillMaxWidth()


    )

    {
//        ListScreen(navController, newsList)
    }

}

@Composable
fun CircularButton(
    @DrawableRes iconResouce: Int,
    color: Color = Color.Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
//    Button(
//        onClick = { },
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.White,
//            contentColor = Color.Red
//        )
//    ) { Text(text = "TEST") }
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = color),
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
        var textOfSearch by remember { mutableStateOf(searchCountry) }


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
//                onDone = { ListScreen1() }
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
    Spacer(modifier = Modifier.padding(12.dp))

    var color by remember { mutableStateOf(Black) }
    val focusRequester = FocusRequester()

    Text(
        modifier = Modifier
            .focusRequester(focusRequester)
            .onFocusChanged { color = if (it.isFocused) Green else Black }
            .focusTarget()
            .focusRequester(focusRequester)
            .clickable { focusRequester.requestFocus() },
//            .pointerInput(Unit) { detectTapGestures { focusRequester.requestFocus() } },
        text = "Text111",
        color = color
    )
}


@ExperimentalComposeUiApi
@Composable
fun ListScreen(
    navController: NavController,
    news: List<News>

) {
    Column(Modifier.fillMaxSize()) {
//////Paint button
//        CircularButton(R.drawable.ic_launcher_background)

//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    navController.navigate(Destinations.SEARCH_SCREEN)
//                },
//                backgroundColor = MaterialTheme.colors.primary
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = stringResource(R.string.Set_search)
//                )
//            }
//        },
////        topBar = {
////            TopAppBar(
////                title = { Text(stringResource(R.string.Top_news)) },
////            )
////        }
//    )
//    {
        SearchEnter()
        /// experimental API on jetpack - ahtung!!!!!
//        val keyboardController = LocalSoftwareKeyboardController.current
//        var textOfSearch by remember { mutableStateOf(searchCountry) }
//
//
//        searchCountry = textOfSearch
//
//        OutlinedTextField(
//            value = textOfSearch,
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(
//                imeAction = ImeAction.Done,
//                keyboardType = KeyboardType.Text
//            ),
//            keyboardActions = KeyboardActions(
//                onDone = { keyboardController?.hide() }
////                onDone = { navController.popBackStack() }
////                onDone = { keyboardController?.hide() }
//            ),
//            onValueChange = { textOfSearch = it },
//            label = {
//                Text(
//                    stringResource(R.string.serchscreenLabel),
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Button(
//
//            onClick = { navController.navigate(Destinations.SEARCH_SCREEN)},
//            colors = ButtonDefaults.buttonColors(
//                backgroundColor = Color.White,
//                contentColor = Color.Red
//            ),
//        elevation=  ButtonDefaults.elevation(
//            defaultElevation = 6.dp,
//            pressedElevation = 8.dp,
//            disabledElevation = 0.dp
//        )
//        ) { Text(text = "TEST1") }
//
        Spacer(modifier = Modifier.padding(2.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            contentPadding = PaddingValues(vertical = 2.dp)
        ) {

////            items(1) {
//                /// experimental API on jetpack - ahtung!!!!!
//                val keyboardController = LocalSoftwareKeyboardController.current
//                var textOfSearch by remember { mutableStateOf("RU") }
//
//
//                searchCountry = textOfSearch
//
//                OutlinedTextField(
//                    value = textOfSearch,
//                    singleLine = true,
//                    keyboardOptions = KeyboardOptions(
//                        imeAction = ImeAction.Done,
//                        keyboardType = KeyboardType.Text
//                    ),
//                    keyboardActions = KeyboardActions(
////                            onDone = { navController.popBackStack() }
//                        onDone = { keyboardController?.hide() }
//                    ),
//                    onValueChange = { textOfSearch = it },
//                    label = {
//                        Text(
//                            stringResource(R.string.serchscreenLabel),
//                            fontSize = 18.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                )
//
//                Button(
//
//                    onClick = { navController.navigate(Destinations.SEARCH_SCREEN) },
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = Color.White,
//                        contentColor = Color.Red
//                    ),
//                    elevation = ButtonDefaults.elevation(
//                        defaultElevation = 6.dp,
//                        pressedElevation = 8.dp,
//                        disabledElevation = 0.dp
//                    )
//                ) { Text(text = "TEST") }
//                Spacer(modifier = Modifier.padding(32.dp))
//            }
            items(news) { new ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("${Destinations.DETAILS_SCREEN}/${new.title}")
                        },
                ) {
                    Column {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f),
                            painter = rememberImagePainter(
                                data = new.urlToImage,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )
                        Column(Modifier.padding(8.dp)) {
                            Text(new.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(new.content ?: "", maxLines = 3)
                        }
                    }

                }
            }
        }

    }
//}


    @Preview(showBackground = true)
    @ExperimentalComposeUiApi
    @Composable
    fun ListPreview() {
        NewsAppTheme {
            ListScreen(
                navController = rememberNavController(),
                news = arrayListOf(
                    News(
                        "Title", "Content description", "", "",
                        "https://via.placeholder.com/540x300?text=yayocode.com"
                    ),
                    News(
                        "Title2", "Content description", "", "",
                        "https://via.placeholder.com/540x300?text=yayocode.com"
                    ),
                    News(
                        "Title2", "Content description", "", "",
                        "https://via.placeholder.com/540x300?text=yayocode.com"
                    )
                )
            )
        }
    }
}