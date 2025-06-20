package com.mpesa.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mpesa.myapplication.ui.components.CustomInputField
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendToBankScreen(navController: NavController, onBack: () -> Unit) {
    val bankOptions = listOf("CBE", "Awash", "Abay Bank")
    val selectedBank = remember { mutableStateOf(bankOptions[0]) }
    val expanded = remember { mutableStateOf(false) }

    val accountNumber = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }

    val isFormValid = remember(accountNumber.value, amount.value) {
        accountNumber.value.isNotBlank()
                && amount.value.isNotBlank()
                && amount.value.toIntOrNull() != null
                && amount.value.toInt() >= 25
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Send to Bank") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { expanded.value = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(selectedBank.value)
                }

                DropdownMenu(
                    modifier = Modifier
                        .fillMaxWidth(),
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }
                ) {
                    bankOptions.forEach { bank ->
                        DropdownMenuItem(
                            text = { Text(bank, modifier = Modifier.fillMaxWidth()) },
                            onClick = {
                                selectedBank.value = bank
                                expanded.value = false
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            CustomInputField(
                value = accountNumber.value,
                onValueChange = { accountNumber.value = it },
                label = "Enter Bank Account Number",
                isNumeric = true,
                keyboardType = KeyboardType.Number
            )

            Spacer(modifier = Modifier.height(12.dp))

            CustomInputField(
                value = amount.value,
                onValueChange = { amount.value = it },
                label = "Birr Amount",
                isNumeric = true,
                keyboardType = KeyboardType.Number
            )

            Spacer(modifier = Modifier.height(12.dp))

            CustomInputField(
                value = description.value,
                onValueChange = { description.value = it },
                label = "Enter Description (optional)",
                keyboardType = KeyboardType.Text
            )

            if (errorMessage.value.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(errorMessage.value, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                enabled = isFormValid,
                onClick = {
                    errorMessage.value = ""

                    val encodedDescription = URLEncoder.encode(description.value, StandardCharsets.UTF_8.toString())
                    val encodedBank = URLEncoder.encode(selectedBank.value, StandardCharsets.UTF_8.toString())
                    val encodedAccount = URLEncoder.encode(accountNumber.value, StandardCharsets.UTF_8.toString())
                    val encodedAmount = URLEncoder.encode(amount.value, StandardCharsets.UTF_8.toString())
                    navController.navigate(
                        "confirmationScreen/$encodedBank/$encodedAccount/$encodedAmount/$encodedDescription"
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continue")
            }
        }
    }
}
