package com.example.simpleunitconverter.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.simpleunitconverter.constant.Constant

class UnitConverterViewModel : ViewModel() {
    val inputValue = mutableStateOf("")
    val inputUnit = mutableStateOf("Select")
    val outputUnit = mutableStateOf("Select")
    val isInputEnabled = mutableStateOf(false)
    val isOutputEnabled  =  mutableStateOf(false)
    val outputValue = mutableStateOf("")

    fun convertUnits(){
        val inputNumber = inputValue.value.toFloatOrNull()?:0F
        var outputNumber = outputValue.value.toFloatOrNull()?:0F
        when(inputUnit.value){
            Constant.METER -> {
                outputNumber = when (outputUnit.value) {
                    Constant.METER -> {
                        inputNumber * 1.0F
                    }

                    Constant.CENTIMETER -> {
                        inputNumber * 100.0F
                    }

                    Constant.MILLIMETER -> {
                        inputNumber * 1000.0F
                    }

                    Constant.FEET -> {
                        inputNumber * 3.281F
                    }
                    else -> { 0F }
                }
            }
            Constant.CENTIMETER -> {
                outputNumber = when (outputUnit.value) {
                    Constant.METER -> {
                        inputNumber * 0.01F
                    }

                    Constant.CENTIMETER -> {
                        inputNumber * 1.0F
                    }

                    Constant.MILLIMETER -> {
                        inputNumber * 10.0F
                    }

                    Constant.FEET -> {
                        inputNumber * 0.394F
                    }
                    else -> { 0F }
                }
            }
            Constant.MILLIMETER ->{
                outputNumber = when (outputUnit.value) {
                    Constant.METER -> {
                        inputNumber * 0.001F
                    }

                    Constant.CENTIMETER -> {
                        inputNumber * 0.1F
                    }

                    Constant.MILLIMETER -> {
                        inputNumber * 1.0F
                    }

                    Constant.FEET -> {
                        inputNumber * 0.0394F
                    }
                    else -> { 0F }
                }
            }
            Constant.FEET ->{
                outputNumber = when (outputUnit.value) {
                    Constant.METER -> {
                        inputNumber * 0.305F
                    }

                    Constant.CENTIMETER -> {
                        inputNumber * 30.48F
                    }

                    Constant.MILLIMETER -> {
                        inputNumber * 304.8F
                    }

                    Constant.FEET -> {
                        inputNumber * 1.0F
                    }
                    else -> { 0F }
                }
            }
        }
        outputValue.value = outputNumber.toString()
    }
}