package com.alpha.feature_bin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpha.core.data.model.BinInfo
import com.alpha.feature_bin.domain.usecases.CheckInternetUseCase
import com.alpha.feature_bin.domain.usecases.GetBinInfoUseCase
import com.alpha.feature_bin.domain.usecases.SaveBinInfoUseCase
import com.alpha.feature_bin.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBinInfoUseCase: GetBinInfoUseCase,
    private val checkInternetUseCase: CheckInternetUseCase,
    private val saveBinInfoUseCase: SaveBinInfoUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<UiState<BinInfo>>(UiState.Loading)
    val binInfo: StateFlow<UiState<BinInfo>> = _binInfo.asStateFlow()

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            _binInfo.value = UiState.Loading

            if (!checkInternetUseCase.invoke()) {
                _binInfo.value = UiState.Error("Нет доступа к интернету")
                return@launch
            }

            try {
                val result = getBinInfoUseCase(bin)
                _binInfo.value = UiState.Success(result)
                saveBinInfoUseCase(
                    result.copy(bin = bin),
                    result.number,
                    result.country,
                    result.bank
                )
            } catch (e: Exception) {
                _binInfo.value = UiState.Error("Проверьте корректность введенного BIN")
            }
        }
    }
}