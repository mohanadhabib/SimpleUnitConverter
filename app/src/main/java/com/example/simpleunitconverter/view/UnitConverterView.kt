package com.example.simpleunitconverter.view

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.simpleunitconverter.constant.Constant
import com.example.simpleunitconverter.ui.theme.textLabelStyle
import com.example.simpleunitconverter.ui.theme.textStyle
import com.example.simpleunitconverter.viewModel.UnitConverterViewModel


@Composable
fun UnitConverter(viewModel: UnitConverterViewModel){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Unit Converter",
            style = textStyle
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = viewModel.inputValue.value,
            label = {
                Text(
                    text = "Please Enter Number",
                    style = textLabelStyle
                )
            },
            onValueChange = {
                viewModel.inputValue.value = it
                viewModel.convertUnits()
            })
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Row {
            Box{
                Button(
                    onClick = {
                        viewModel.isInputEnabled.value = !viewModel.isInputEnabled.value
                    }) {
                    Text(
                        text = viewModel.inputUnit.value,
                        style = textLabelStyle
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Color.Black)
                }
                DropdownMenu(
                    expanded = viewModel.isInputEnabled.value,
                    onDismissRequest = {
                        viewModel.isInputEnabled.value = false
                    }) {
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.CENTIMETER)
                        },
                        onClick = {
                            viewModel.inputUnit.value = Constant.CENTIMETER
                            viewModel.isInputEnabled.value = false
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.METER)
                        },
                        onClick = {
                            viewModel.inputUnit.value = Constant.METER
                            viewModel.isInputEnabled.value = false
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.MILLIMETER)
                        },
                        onClick = {
                            viewModel.inputUnit.value = Constant.MILLIMETER
                            viewModel.isInputEnabled.value = false
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.FEET)
                        },
                        onClick = {
                            viewModel.inputUnit.value = Constant.FEET
                            viewModel.isInputEnabled.value = false
                            viewModel.convertUnits()
                        })
                }
            }
            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Box {
                Button(
                    onClick = {
                        viewModel.isOutputEnabled.value = !viewModel.isOutputEnabled.value
                    }) {
                    Text(
                        text = viewModel.outputUnit.value,
                        style = textLabelStyle
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Color.Black)
                }
                DropdownMenu(
                    expanded = viewModel.isOutputEnabled.value,
                    onDismissRequest = {
                        viewModel.isOutputEnabled.value = false
                    }) {
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.CENTIMETER)
                        },
                        onClick = {
                            viewModel.outputUnit.value = Constant.CENTIMETER
                            viewModel.isOutputEnabled.value = false
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.METER)
                        },
                        onClick = {
                            viewModel.outputUnit.value = Constant.METER
                            viewModel.isOutputEnabled.value = false
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.MILLIMETER)
                        },
                        onClick = {
                            viewModel.outputUnit.value = Constant.MILLIMETER
                            viewModel.isOutputEnabled.value = false
                            viewModel.convertUnits()
                        })
                    DropdownMenuItem(
                        text = {
                            Text(text = Constant.FEET)
                        },
                        onClick = {
                            viewModel.outputUnit.value = Constant.FEET
                            viewModel.isOutputEnabled.value = false
                            viewModel.convertUnits()
                        })
                }
            }
        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = "Result : ${viewModel.outputValue.value}",
            style = textStyle
        )
    }
}
