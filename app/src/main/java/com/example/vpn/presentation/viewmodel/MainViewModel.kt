package com.example.vpn.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vpn.domain.model.vpn.VpnDataResponse
import com.example.vpn.domain.repository.Repository
import com.example.vpn.domain.usecase.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _allVpnData = MutableStateFlow<ResultState<VpnDataResponse?>>(ResultState.Loading)
    val allVpnData: StateFlow<ResultState<VpnDataResponse?>> = _allVpnData.asStateFlow()

    private val _isConnected = MutableStateFlow(false)
    val isConnected: StateFlow<Boolean> = _isConnected

    fun connectVpn() {
        viewModelScope.launch {
            try {
                val response = repository.getVpnData()
                _allVpnData.value = ResultState.Success(response)
                _isConnected.value = true
            } catch (e: Exception) {
                _allVpnData.value = ResultState.Error(e)
            }
        }
    }

    fun disconnectVpn() {
        viewModelScope.launch {
            try {
                _isConnected.value = false
            } catch (e: Exception) {
            }
        }
    }
}
