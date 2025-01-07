package com.alpha.testwork.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alpha.feature_bin.presentation.screen.MainScreen
import com.alpha.feature_bin.presentation.viewmodel.MainViewModel
import com.alpha.feature_history.presentation.screen.HistoryScreen
import com.alpha.feature_history.presentation.viewmodel.HistoryViewModel

@Composable
fun AppNavigation(
    mainViewModel: MainViewModel,
    historyViewModel: HistoryViewModel,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "main_screen"
    ) {
        composable("main_screen",
            enterTransition = { fadeIn(animationSpec = tween(100)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) }
        ) {
            MainScreen(
                navController = navController,
                mainViewModel = mainViewModel,
            )
        }
        composable(
            "history_screen",
            enterTransition = { fadeIn(animationSpec = tween(100)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) }
        ) {
            historyViewModel.fetchBinHistoryInfo()
            HistoryScreen(
                navController = navController,
                historyViewModel = historyViewModel
            )
        }
    }
}