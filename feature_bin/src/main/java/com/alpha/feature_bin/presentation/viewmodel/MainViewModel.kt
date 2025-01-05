package com.alpha.feature_bin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpha.core.models.BinInfoDomain
import com.alpha.feature_bin.domain.usecases.GetBinInfoUseCase
import com.alpha.feature_bin.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getBinInfoUseCase: GetBinInfoUseCase): ViewModel() {
    private val _binInfo = MutableStateFlow<UiState<BinInfoDomain>>(UiState.Loading)
    val binInfo: StateFlow<UiState<BinInfoDomain>>
        get() = _binInfo.asStateFlow()

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            _binInfo.value = UiState.Loading
            try {
                val result = getBinInfoUseCase(bin)
                _binInfo.value = UiState.Success(result)
            } catch (e: Exception) {
                _binInfo.value = UiState.Error(e.message ?: "Error fetching BIN info")
            }
        }
    }
}