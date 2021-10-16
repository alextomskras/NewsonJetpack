package com.dreamer.newsonjetpack.ui.presentation.viewmodel.list

//import com.dreamer.newsonjetpack.Destinations
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
import com.dreamer.newsonjetpack.ui.theme.NewsAppTheme

object Destinations {
    const val LIST_SCREEN = "LIST_SCREEN"
    const val DETAILS_SCREEN = "DETAILS_SCREEN"
    const val SEARCH_SCREEN = "SEARCH_SCREEN"
}

@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val newsList by viewModel.getNews().observeAsState(initial = emptyList())
    ListScreen(navController, newsList)

}

@Composable
fun ListScreen(
    navController: NavController,
    news: List<News>
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Destinations.SEARCH_SCREEN)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.Set_search)
                )
            }
        }
//        topBar = {
//            TopAppBar(
//                title = { Text(stringResource(R.string.Top_news)) },
//            )
//        }
    )
    {
        LazyColumn {
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
}

@Preview(showBackground = true)
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