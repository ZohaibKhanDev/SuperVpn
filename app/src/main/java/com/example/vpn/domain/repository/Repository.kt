package com.example.vpn.domain.repository

import com.example.vpn.data.remote.VpnApiClient
import com.example.vpn.data.repository.ApiClient
import com.example.vpn.domain.model.vpn.VpnDataResponse

class Repository : ApiClient {
    override suspend fun getVpnData(): VpnDataResponse? {
        return VpnApiClient.getVpnData()
    }
}