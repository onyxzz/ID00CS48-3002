package com.example.week_8.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week_8.model.Todo
import com.example.week_8.ui.theme.Week8Theme
import com.example.week_8.viewmodel.TodoUIState
import com.example.week_8.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week8Theme {
                //A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TodoApp(todoViewModel: TodoViewModel = viewModel()) {
    TodoScreen(uiState = todoViewModel.todoUIState)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Todos") }
            )
        },
        content = {
            TodoScreen(uiState = todoViewModel.todoUIState)
        }
    )
}

@Composable
fun TodoScreen(uiState: TodoUIState) {
    when (uiState) {
        is TodoUIState.Loading -> LoadingScreen()
        is TodoUIState.Success -> TodoList(uiState.todos)
        is TodoUIState.Error -> ErrorScreen()
    }
}

@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Week8Theme {
        TodoApp()
    }
}