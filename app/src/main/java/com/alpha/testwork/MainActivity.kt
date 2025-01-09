package com.alpha.testwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.alpha.feature_bin.presentation.viewmodel.MainViewModel
import com.alpha.feature_history.presentation.viewmodel.HistoryViewModel
import com.alpha.testwork.navigation.AppNavigation
import com.alpha.testwork.ui.theme.AlphaTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel: MainViewModel by viewModels()
    val historyViewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlphaTestAppTheme {
                AppNavigation(
                    mainViewModel = mainViewModel,
                    historyViewModel = historyViewModel
                )
            }
        }
    }
}

