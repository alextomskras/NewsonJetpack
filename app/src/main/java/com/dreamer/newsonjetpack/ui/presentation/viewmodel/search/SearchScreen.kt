package com.dreamer.newsonjetpack.ui.presentation.viewmodel.search


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.dreamer.newsonjetpack.ui.theme.NewsAppTheme

@Composable
fun SearchScreen(
//    newTitle: String,
    navController: NavController,
    viewModel: SearchScreenViewModel = hiltViewModel()
) {
//    val newsList by viewModel.getNews().observeAsState(initial = emptyList())
    SearchScreen(navController)

}

@Composable
fun SearchScreen(
    navController: NavController
) {
    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
////                    navController.navigate(Screen.AddEditNoteScreen.route)
//                },
//                backgroundColor = MaterialTheme.colors.primary
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(R.string.Add_note))
//            }
//        }
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.search_settings)) },
            )
        }
    )
    {
//        new?.let {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f),
                    painter = rememberImagePainter(
                        data = "urlToImage",
                        builder = {
                            placeholder(R.drawable.placeholder)
                            error(R.drawable.placeholder)
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
                Column(Modifier.padding(8.dp)) {
                    val context = LocalContext.current

                    val newtitle = ""
                    Text(newtitle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    val content = "null"
                    Text(content)
                    Box(Modifier.size(8.dp))
//                        Button(
//                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
//                            onClick = {
//                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(new.url))
//                                context.startActivity(intent)
//                            }
//                        )
                    {
                        Text(stringResource(R.string.open_news_link))
                    }
                }
            }
        }
    }
}
//}


@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    NewsAppTheme {
        SearchScreen(
//            title = "Hello",
            navController = rememberNavController(),
//            new = News(
//                "Title", "Content description", "", "",
//                "https://via.placeholder.com/540x300?text=yayocode.com"
//            )
        )
    }
}
