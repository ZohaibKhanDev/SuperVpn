package com.example.vpn.domain.model.vpn


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VpnDataResponseItem(
    @SerialName("country_long")
    val countryLong: String,
    @SerialName("country_short")
    val countryShort: String,
    @SerialName("host_name")
    val hostName: String,
    @SerialName("ip")
    val ip: String,
    @SerialName("log_type")
    val logType: String,
    @SerialName("message")
    val message: String,
    @SerialName("num_vpn_sessions")
    val numVpnSessions: String,
    @SerialName("openvpn_config_data_base64")
    val openvpnConfigDataBase64: String,
    @SerialName("operator")
    val `operator`: String,
    @SerialName("ping")
    val ping: String,
    @SerialName("score")
    val score: String,
    @SerialName("speed")
    val speed: String,
    @SerialName("total_traffic")
    val totalTraffic: String,
    @SerialName("total_users")
    val totalUsers: String,
    @SerialName("uptime")
    val uptime: String
)