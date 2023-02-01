package com.example.week3assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week3assignment.ui.theme.Week3AssignmentTheme
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week3AssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    var username: String by remember { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }
    var passwordVisibility: Boolean by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.login),
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    bottom = 12.dp
                )
        )

        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = {Text(text = stringResource(R.string.email))},
            trailingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text(text = stringResource(R.string.password))},
            trailingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Visible Password")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.button))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Week3AssignmentTheme {
        LoginForm()
    }
}