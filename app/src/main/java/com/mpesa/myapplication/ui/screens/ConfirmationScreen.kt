package com.mpesa.myapplication.ui.screens

import StackedAvatars
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun ConfirmationScreen(
    bank: String,
    account: String,
    amount: String,
    description: String,
    onBack: () -> Unit
) {
    val pin = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }

    val keypad = listOf(
        "1", "2", "3",
        "4", "5", "6",
        "7", "8", "9",
        "", "0", "⌫"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Bank: $bank")
        Text("Account: $account")
        Text("Amount: $amount Birr")
        Text("Description: ${if (description.isBlank()) "None" else description}")

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        Text("Enter PIN", fontWeight = FontWeight.Bold)

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = if (index < pin.value.length) Color.Black else Color.LightGray,
                            shape = CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            keypad.chunked(3).forEach { row ->
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    row.forEach { key ->
                        Button(
                            onClick = {
                                when (key) {
                                    "⌫" -> {
                                        if (pin.value.isNotEmpty()) {
                                            pin.value = pin.value.dropLast(1)
                                            message.value = ""
                                        }
                                    }
                                    "" -> Unit
                                    else -> {
                                        if (pin.value.length < 4) {
                                            pin.value += key
                                        }
                                    }
                                }
                            },
                            enabled = key.isNotEmpty(),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                        ) {
                            Text(key, fontSize = 18.sp)
                        }
                    }
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Button(onClick = onBack) {
                Text("Back")
            }
            Button(
                onClick = {
                    message.value = "Transaction Successful!"
                },
                enabled = pin.value.length == 4
            ) {
                Text("Done")
            }

        }

        if (message.value.isNotBlank()) {
            Text(
                text = message.value,
                color = if (message.value.contains("Success")) Color.Green else Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
