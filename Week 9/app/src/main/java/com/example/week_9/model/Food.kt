package com.example.week_9.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class Success(val foods: List<Food>)

data class Food(
    var id: Int,
    var title: String,
)

const val BASE_URL = "https://api.spoonacular.com/food/menuItems/"

interface FoodsApi {
    @GET("search")
    suspend fun getFoods(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("number") number: Int
    ): List<Food>

    companion object {
        var foodsService: FoodsApi? = null

        fun getInstance(): FoodsApi {
            if (foodsService === null) {
                foodsService = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(FoodsApi::class.java)
            }
            return foodsService!!
        }
    }
}