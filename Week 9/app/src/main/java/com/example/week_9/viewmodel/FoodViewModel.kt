package com.example.week_9.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week_9.model.Food
import com.example.week_9.model.FoodsApi
import kotlinx.coroutines.launch

var apikey: String = "fea2370c4f0844c1a34700b60f7c3c15"
var query: String = "burger"
var number: Int = 2

sealed interface FoodUIState {
    data class Success(val foods: List<Food>) : FoodUIState
    object Error : FoodUIState
    object Loading : FoodUIState
}

class FoodViewModel : ViewModel() {
    var foodUIState: FoodUIState by mutableStateOf<FoodUIState>(FoodUIState.Loading)
        private set

    init {
        getFoodsList()
    }

    private fun getFoodsList() {
        viewModelScope.launch {
            var foodsApi: FoodsApi? = null
            try {
                foodsApi = FoodsApi!!.getInstance()
                foodUIState = FoodUIState.Success(foodsApi.getFoods(apikey, query, number))
            } catch (e: java.lang.Exception) {
                Log.d("FOODVIEWMODEL", e.message.toString())
                foodUIState = FoodUIState.Error
            }
        }
    }
}