package com.example.vpn.data.repository

import com.example.vpn.domain.model.vpn.VpnDataResponse

interface ApiClient {
    suspend fun getVpnData():VpnDataResponse?
}