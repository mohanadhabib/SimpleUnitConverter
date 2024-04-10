package com.example.simpleunitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleunitconverter.ui.theme.SimpleUnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleUnitConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

class Constant{
    companion object {
        const val CENTIMETER = "Centimeter"
        const val METER = "Meter"
        const val FEET = "Feet"
        const val MILLIMETER = "Millimeter"
    }
}

val textStyle = TextStyle(
    color = Color.DarkGray,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    fontFamily = FontFamily.Serif,
    fontStyle = FontStyle.Normal
)

val textLabelStyle = TextStyle(
    color = Color.Black,
    fontSize = 15.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = FontFamily.Serif,
    fontStyle = FontStyle.Normal
)

@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Select") }
    var outputUnit by remember { mutableStateOf("Select") }
    var isInputEnabled by remember { mutableStateOf(false) }
    var isOutputEnabled by remember { mutableStateOf(false) }
    var outputValue by remember { mutableStateOf("") }

    fun convertUnits(){
        val inputNumber = inputValue.toFloatOrNull()?:0F
        var outputNumber = outputValue.toFloatOrNull()?:0F
        when(inputUnit){
            Constant.METER -> {
                outputNumber = when (outputUnit) {
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
                outputNumber = when (outputUnit) {
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
                outputNumber = when (outputUnit) {
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
                outputNumber = when (outputUnit) {
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
        outputValue = outputNumber.toString()
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Unit Converter",
            style = textStyle)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = inputValue,
            label = {
                Text(
                    text = "Please Enter Number",
                    style = textLabelStyle
                )},
            onValueChange = {
                inputValue = it
                convertUnits()
            })
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Box{
                Button(onClick = { isInputEnabled = !isInputEnabled}) {
                    Text(
                        text = inputUnit,
                        style = textLabelStyle
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Color.Black)
                }
                DropdownMenu(expanded = isInputEnabled, onDismissRequest = { isInputEnabled = false}) {
                    DropdownMenuItem(
                        text = {Text(text = Constant.CENTIMETER)},
                        onClick = {
                            inputUnit = Constant.CENTIMETER
                            isInputEnabled = false
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text(text = Constant.METER)},
                        onClick = {
                            inputUnit = Constant.METER
                            isInputEnabled = false
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text(text = Constant.MILLIMETER)},
                        onClick = {
                            inputUnit = Constant.MILLIMETER
                            isInputEnabled = false
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text(text = Constant.FEET)},
                        onClick = {
                            inputUnit = Constant.FEET
                            isInputEnabled = false
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Box {
                Button(onClick = { isOutputEnabled = !isOutputEnabled }) {
                    Text(
                        text = outputUnit,
                        style = textLabelStyle
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Color.Black)
                }
                DropdownMenu(expanded = isOutputEnabled, onDismissRequest = { isOutputEnabled = false }) {
                    DropdownMenuItem(
                        text = {Text(text = Constant.CENTIMETER)},
                        onClick = {
                            outputUnit = Constant.CENTIMETER
                            isOutputEnabled = false
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text(text = Constant.METER)},
                        onClick = {
                            outputUnit = Constant.METER
                            isOutputEnabled = false
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text(text = Constant.MILLIMETER)},
                        onClick = {
                            outputUnit = Constant.MILLIMETER
                            isOutputEnabled = false
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = {Text(text = Constant.FEET)},
                        onClick = {
                            outputUnit = Constant.FEET
                            isOutputEnabled = false
                            convertUnits()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Result : $outputValue",
            style = textStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
