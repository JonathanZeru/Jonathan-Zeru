package com.mpesa.myapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CustomInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isNumeric: Boolean = false,
    keyboardType: KeyboardType,
    maxLength: Int = 100
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                val filtered = if (isNumeric) it.filter { it.isDigit() } else it
                if (filtered.length <= maxLength) {
                    onValueChange(filtered)
                }
            },
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = {
                if (label == "Enter Bank Account Number") {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person Icon"
                    )
                }
            }
        )

        if (label == "Birr Amount") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 4.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "BALANCE: 3,235.18 BIRR",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    color = Color(0xFF80CBC4)
                )
            }
        }

        if (label == "Enter Description (optional)") {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "${value.length} / $maxLength",
                    fontSize = 12.sp,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
