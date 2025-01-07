package com.alpha.feature_history.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpha.core.data.model.BinInfo
import com.alpha.feature_history.domain.usecase.GetAllBinInfoUseCase
import com.alpha.feature_history.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getAllBinInfoUseCase: GetAllBinInfoUseCase
) : ViewModel()
{
    private val _binHistoryInfo = MutableStateFlow<UiState<List<BinInfo>>>(UiState.Loading)
    val binHistoryInfo: StateFlow<UiState<List<BinInfo>>> = _binHistoryInfo.asStateFlow()

    fun fetchBinHistoryInfo() {
        viewModelScope.launch {
            try {
                val result = getAllBinInfoUseCase()
                _binHistoryInfo.value = UiState.Success(result)
            } catch (e: Exception) {
                _binHistoryInfo.value = UiState.Error("Произошла проблема при загрузке истории запросов :( $e")
            }
        }
    }
}