package com.mpesa.myapplication.ui.screens

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mpesa.myapplication.ui.components.AddMoneyOptionCard
import com.mpesa.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMoneyScreen(navController: NavController, onBack: () -> Unit) {
    val banks = remember {
        listOf(
            mapOf("name" to "Transfer from Bank", "description" to "Use your bank account to add money instantly."),
            mapOf("name" to "Deposit at Agent", "description" to "Visit an agent near you and deposit cash."),
            mapOf("name" to "Ask a friend", "description" to "Request a transfer from a friend or family member."),
            mapOf("name" to "Receive from abroad", "description" to "Receive money from your loved ones across the world instantly via M-PESA")
        )
    }

    val imageUrls = listOf(
        R.drawable.logo.toString(),
        R.drawable.logo.toString(),
        R.drawable.logo.toString()
    )

    val iconColors = listOf(
        Color(0xFF2196F3),
        Color(0xFF4CAF50),
        Color(0xFFFFC107),
        Color(0xFFF44336)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Money", fontSize = 20.sp, color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            // Center Icon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add Icon",
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, CircleShape)
                        .border(6.dp, MaterialTheme.colorScheme.primary, CircleShape),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = "ADD MONEY",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "How can you fund your M-PESA account:",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(banks.size) { index ->
                    val bank = banks[index]
                    AddMoneyOptionCard(
                        navController = navController,
                        name = bank["name"] ?: "",
                        description = bank["description"] ?: "",
                        iconColor = iconColors[index % iconColors.size],
                        imageUrls = imageUrls
                    )
                }
            }
        }
    }
}
