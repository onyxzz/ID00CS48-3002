package com.example.week_9.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week_9.ui.components.Calculator
import com.example.week_9.ui.components.MainScreen
import com.example.week_9.ui.components.MealSelect
import com.example.week_9.ui.theme.Week9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week9Theme {
                TdeeScaffold()
            }
        }
    }
}

@Composable
fun TdeeScaffold() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(route = "Home") {
            MainScreen(navController)
        }
        composable(route = "Calculator") {
            Calculator(navController = navController)
        }
        composable(route = "Meal Select") {
            MealSelect(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Week9Theme {
        TdeeScaffold()
    }
}