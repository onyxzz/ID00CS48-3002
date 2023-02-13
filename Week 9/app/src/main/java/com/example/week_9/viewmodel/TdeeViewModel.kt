package com.example.week_9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TdeeViewModel : ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    var ageInput by mutableStateOf("")
    var gender by mutableStateOf(true)

    private var height: Int = 0
        get() {
            return heightInput.toIntOrNull() ?: 0
        }
    private var weight: Float = 0.0f
        get() {
            return weightInput.toFloatOrNull() ?: 0.0f
        }
    private var age: Int = 0
        get() {
            return ageInput.toIntOrNull() ?: 0
        }

    var result: Int = 0
        get() {
            return if (weight > 0 && height > 0 && age > 0) {
                return if (gender) {
                    (10 * weight + 6.25 * height - 5 * age + 5).toInt()
                } else {
                    (10 * weight + 6.25 * height - 5 * age - 161).toInt()
                }
            } else {
                0
            }
        }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    fun changeAgeInput(value: String) {
        ageInput = value
    }

    fun changeGenderInput(value: Boolean) {
        gender = value
    }
}