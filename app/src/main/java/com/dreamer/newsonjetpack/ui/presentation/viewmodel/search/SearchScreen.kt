package com.dreamer.newsonjetpack.ui.presentation.viewmodel.search


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dreamer.newsonjetpack.R
import com.dreamer.newsonjetpack.ui.theme.NewsAppTheme

var searchCountry: String = "RU"

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
                title = { Text(stringResource(R.string.search_settings), maxLines = 1) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
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
//                Image(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(16f / 9f),
//                    painter = rememberImagePainter(
//                        data = "urlToImage",
//                        builder = {
//                            placeholder(R.drawable.placeholder)
//                            error(R.drawable.placeholder)
//                        }
//                    ),
//                    contentDescription = null,
//                    contentScale = ContentScale.FillWidth
//                )
                Column(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )

                {
                    var textOfSearch by remember { mutableStateOf("") }
                    searchCountry = textOfSearch

                    OutlinedTextField(

                        value = textOfSearch,
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
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
//                    MyTextField(
//                        label = "User Name",
//                        value = myViewmodel.text,
//                        onValueChanged = { myViewmodel.onTextChanged(it) }
//                    )
//                    MyTextField(
//                        label = "Password",
//                        visualTransformation = PasswordVisualTransformation(),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                        value = myViewmodel.password,
//                        onValueChanged = { myViewmodel.onPasswordChanged(it) }
//                    )
                    Button(
                        onClick = {
//                            scope.launch {
//                                scaffoldState
//                                    .snackbarHostState
//                                    .showSnackbar("Hello, ${myViewmodel.text}")
//                            }
                        },
                        modifier = Modifier.align(Alignment.End),
//                        enabled = myViewmodel.text.isNotBlank() && myViewmodel.password.isNotBlank(),
                    ) {
                        Text(text = "Submit")
                    }
                }
//                }

//                Column(Modifier.padding(8.dp)) {
//                    val context = LocalContext.current
//
//                    val newtitle = ""
//                    Text(newtitle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//                    val content = "null"
//                    Text(content)
//                    Box(Modifier.size(8.dp))
////                        Button(
////                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
////                            onClick = {
////                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(new.url))
////                                context.startActivity(intent)
////                            }
////                        )
//                    {
//                        Text(stringResource(R.string.open_news_link))
//                    }

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
