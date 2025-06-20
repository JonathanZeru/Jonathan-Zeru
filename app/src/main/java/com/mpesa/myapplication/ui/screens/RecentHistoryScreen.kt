//package com.mpesa.myapplication.ui.screens
//
//import TransferViewModel
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//
//import com.google.accompanist.swiperefresh.SwipeRefresh
//import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
//import com.mpesa.myapplication.data.Transfer
//import kotlinx.coroutines.delay
//import java.text.SimpleDateFormat
//import java.util.*
//
//@Composable
//fun RecentTransfersScreen() {
//    val viewModel: TransferViewModel = hiltViewModel()
//
//    val transfers by viewModel.transfers.collectAsState()
//
//    LazyColumn {
//        items(transfers) { transfer ->
//            TransferItem(
//                transfer = transfer,
//                onClick = {}
//            )
//        }
//
//        item {
//            Button(onClick = { viewModel.insertDummyTransfers() }) {
//                Text("Add Dummy Transfer")
//            }
//        }
//    }
//}