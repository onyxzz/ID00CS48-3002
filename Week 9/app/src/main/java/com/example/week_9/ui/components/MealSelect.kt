package com.example.week_9.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week_9.R
import com.example.week_9.viewmodel.FoodViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MealSelect(foodViewModel: FoodViewModel = viewModel(), navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar(title = stringResource(R.string.mealSelect), navController)},
        content = {
            FoodScreen(uiState = foodViewModel.foodUIState)
        }
    )
}