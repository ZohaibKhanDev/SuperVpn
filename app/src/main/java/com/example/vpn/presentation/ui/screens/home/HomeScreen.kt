package com.example.vpn.presentation.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vpn.domain.model.vpn.VpnDataResponse
import com.example.vpn.domain.usecase.ResultState
import com.example.vpn.presentation.viewmodel.MainViewModel
import org.koin.compose.koinInject

@SuppressLint("MutableCollectionMutableState")
@Composable
fun HomeScreen() {
    var isLoading by remember {
        mutableStateOf(false)
    }

    val viewModel: MainViewModel = koinInject()

    var vpnData by remember {
        mutableStateOf<VpnDataResponse?>(null)
    }

    val state by viewModel.allVpnData.collectAsState()

    val isConnected by viewModel.isConnected.collectAsState()

    when (state) {
        is ResultState.Error -> {
            isLoading = false
            val error = (state as ResultState.Error).error
            Text(text = error.toString())
        }

        ResultState.Loading -> {
            isLoading = true
        }

        is ResultState.Success -> {
            isLoading = false
            val success = (state as ResultState.Success).success
            vpnData = success
        }
    }

    if (isLoading) {
        CircularProgressIndicator()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (isConnected) {
            Text(text = "Connected")
        } else {
            Text(text = "Disconnected")
        }
        Button(
            onClick = {
                if (isConnected) {
                    viewModel.disconnectVpn()
                } else {
                    isLoading = true
                    viewModel.connectVpn()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = if (isConnected) "Disconnect" else "Connect")
        }
    }
}

