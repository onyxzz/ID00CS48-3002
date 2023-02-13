package com.example.week_9.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week_9.R
import com.example.week_9.viewmodel.TdeeViewModel

@Suppress("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Calculator(tdeeViewModel: TdeeViewModel = viewModel(), navController: NavController) {
    var intensity by remember {
        mutableStateOf(1.3f)
    }
    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.tdeeCalculator), navController) },
    ) {
        Column(
            modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Heading(title = stringResource(R.string.headingTDEE))

            OutlinedTextField(
                value = tdeeViewModel.heightInput,
                onValueChange = { tdeeViewModel.changeHeightInput(it) },
                label = { Text(stringResource(R.string.heightInput)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = tdeeViewModel.weightInput,
                onValueChange = { tdeeViewModel.changeWeightInput(it) },
                label = { Text(stringResource(R.string.weightInput)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = tdeeViewModel.ageInput,
                onValueChange = { tdeeViewModel.changeAgeInput(it) },
                label = { Text(stringResource(R.string.ageInput)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            GenderChoices(
                tdeeViewModel.gender,
                setGenderMale = { tdeeViewModel.changeGenderInput(it) }
            )

            IntensityList(onClick = { intensity = it })

            Text(
                text = "${(tdeeViewModel.result * intensity.toInt())}",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}