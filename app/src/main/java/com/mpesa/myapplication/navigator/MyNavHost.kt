package com.mpesa.myapplication
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mpesa.myapplication.ui.screens.AddMoneyScreen
import com.mpesa.myapplication.ui.screens.ConfirmationScreen
import com.mpesa.myapplication.ui.screens.HomeScreen
import com.mpesa.myapplication.ui.screens.ReceiveFromAbroadScreen
import com.mpesa.myapplication.ui.screens.SendToBankScreen
import java.net.URLDecoder

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController, onBack = { navController.popBackStack() })
        }

        composable("addMoneyScreen") {
            AddMoneyScreen(navController, onBack = { navController.popBackStack() })
        }
        composable(
            "receiveFromAbroad/{name}/{description}",
            arguments = listOf(
                navArgument("name") { defaultValue = "" },
                navArgument("description") { defaultValue = "" }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            ReceiveFromAbroadScreen(
                name = name,
                description = description,
                onBack = { navController.popBackStack() }
            )
        }

        composable("sendToBankScreen") {
            SendToBankScreen(
                navController = navController,
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            "confirmationScreen/{bank}/{account}/{amount}/{desc}",
            arguments = listOf(
                navArgument("bank") { defaultValue = "" },
                navArgument("account") { defaultValue = "" },
                navArgument("amount") { defaultValue = "" },
                navArgument("desc") { defaultValue = "" }
            )
        ) { backStackEntry ->
            val bank = URLDecoder.decode(backStackEntry.arguments?.getString("bank") ?: "", "UTF-8")
            val account = URLDecoder.decode(backStackEntry.arguments?.getString("account") ?: "", "UTF-8")
            val amount = URLDecoder.decode(backStackEntry.arguments?.getString("amount") ?: "", "UTF-8")
            val desc = URLDecoder.decode(backStackEntry.arguments?.getString("desc") ?: "", "UTF-8")

            ConfirmationScreen(
                bank = bank,
                account = account,
                amount = amount,
                description = desc,
                onBack = { navController.popBackStack("home", false) }
            )
        }


//        composable("recentTransfers") {
//            RecentTransferHistoryScreen(
//                viewModel = transferViewModel,
//                onTransferClick = { transfer ->
//                    navController.currentBackStackEntry?.savedStateHandle?.set("selectedTransfer", transfer)
//                    navController.navigate("transfer_detail")
//                }
//            )
//        }
    }
}

