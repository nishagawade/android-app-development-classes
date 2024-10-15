package com.example.myreceipeapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myreceipeapp.Category

@Composable
fun ReceipeScreen(modifier: Modifier = Modifier){

    val receipeViewModel : MainViewModel  = viewModel();
    val viewstate by receipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading ->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewstate.error != null ->{
                Text(text = "Error Occured")
            }else ->{
                //display categories
                CategoryScreen(categories = viewstate.list )
            }
        }
    }


}

//fun , to see how categories look like
@Composable

fun CategoryScreen(categories : List<Category>){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
      items(categories){
          category ->
          CategoryItem(category = category)
      }
    }
}


//fun to see , how individual items look like

@Composable

fun CategoryItem(category: Category){

    Column (modifier = Modifier.padding(8.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){


        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
            )



        //displaying the text of the image

        Text(
            text = category.strCategory,  //name of category
            color = Color.Black,
            style = TextStyle(),
            modifier = Modifier.padding(top = 4.dp)
            )
    }
}