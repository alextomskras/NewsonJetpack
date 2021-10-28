package com.dreamer.newsonjetpack.ui.presentation.viewmodel.search

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dreamer.newsonjetpack.R
import com.dreamer.newsonjetpack.model.SampleData
import com.dreamer.newsonjetpack.ui.presentation.viewmodel.list.getListOfCountries
import com.dreamer.newsonjetpack.utils.AutoCompleteName
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun SampleList(navController: NavController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "SampleData.json")
    val gson = Gson()
    val listSampleType = object : TypeToken<List<SampleData>>() {}.type
//    var sampleData: List<SampleData> = gson.fromJson(dataFileString, listSampleType)
    var sampleData: List<String> = getListOfCountries()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(colorResource(id = com.dreamer.newsonjetpack.R.color.design_default_color_primary)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Auto Complete Text",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        AutoCompleteName(sampleData)

        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
        ) {
            items(sampleData) { data ->
                SampleDataListItem(data, navController)
            }
        }
    }
}

@Composable
fun SampleDataListItem(data: String, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                val itemVal = Gson().toJson(data)
                navController.navigate("sample_detail/${itemVal}")
            }
            .padding(10.dp)
            .fillMaxSize(),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Image",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
//                Text(text = data[1].toString(), fontSize = 15.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.padding(5.dp))

//                Text(text = data[0].toString(), fontSize = 15.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}

fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}