package com.example.week_4_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week_4_assignment.ui.theme.Week4assignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week4assignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val appModifier = Modifier.fillMaxWidth().padding(8.dp)
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "My title",
            style = MaterialTheme.typography.h5,
            modifier = appModifier
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            modifier = appModifier
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = appModifier
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Week4assignmentTheme {
        MyApp()
    }
}