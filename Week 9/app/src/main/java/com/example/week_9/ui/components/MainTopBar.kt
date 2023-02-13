package com.example.week_9.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.week_9.R

@Composable
fun MainTopBar(title: String, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(title = { Text(title) },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    Icons.Filled.MoreVert, contentDescription = null
                )
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(onClick = { navController.navigate("Calculator") }) {
                    Text(stringResource(R.string.calculator))
                }

                DropdownMenuItem(onClick = { navController.navigate("Meal Select") }) {
                    Text(stringResource(R.string.mealSelect))
                }
            }
        })
}