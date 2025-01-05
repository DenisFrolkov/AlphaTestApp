package com.alpha.testwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import com.alpha.feature_bin.presentation.utils.UiState
import com.alpha.feature_bin.presentation.viewmodel.MainViewModel
import com.alpha.testwork.ui.theme.AlphaTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val bin = mainViewModel.binInfo.collectAsState().value
            AlphaTestAppTheme {
                mainViewModel.fetchBinInfo("45717360")
                Column {
                    Button(onClick = {mainViewModel.fetchBinInfo("45717360")}) { }
                    when (bin) {
                        is UiState.Loading -> { Text("Загрузка") }
                        is UiState.Success -> {
                            Text(bin.data.toString())
                        }
                        is UiState.Error -> { Text("Ошибка") }
                    }
                }

            }
        }
    }
}