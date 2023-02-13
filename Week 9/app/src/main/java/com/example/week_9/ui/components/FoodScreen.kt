package com.example.week_9.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.week_9.model.Food
import com.example.week_9.viewmodel.FoodUIState

@Composable
fun FoodScreen(uiState: FoodUIState) {
    when (uiState) {
        is FoodUIState.Loading -> LoadingScreen()
        is FoodUIState.Success -> FoodList(uiState.foods)
        is FoodUIState.Error -> ErrorScreen()
    }
}

@Composable
fun FoodList(foods: List<Food>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(foods) { food ->
            Text(
                text = food.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun LoadingScreen() {
    Text("Loading...")
}

@Composable
fun ErrorScreen() {
    Text("Error retrieving data from API.")
}