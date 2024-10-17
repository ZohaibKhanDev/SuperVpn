package com.example.vpn.data.remote

import com.example.vpn.domain.model.vpn.VpnDataResponse
import com.example.vpn.utils.Constant.TIMEOUT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object VpnApiClient {
    @OptIn(ExperimentalSerializationApi::class)
    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
            )
        }

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }

        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT
            socketTimeoutMillis = TIMEOUT
            requestTimeoutMillis = TIMEOUT
        }
    }

    suspend fun getVpnData(): VpnDataResponse? {
        val headers = headers {
            append("x-rapidapi-host", "free-vpn.p.rapidapi.com")
            append("x-rapidapi-key", "0e3e36a41dmsh01f5d1b030cc6cfp103c0ejsn9c29801473d0")
        }
        return try {
            val rawResponse: String = client.get("https://free-vpn.p.rapidapi.com/get_vpn_data") {
                this.headers.appendAll(headers)
            }.bodyAsText()

            println("API Raw Response: $rawResponse")

            if (rawResponse.isNotBlank()) {
                Json.decodeFromString<VpnDataResponse>(rawResponse)
            } else {
                println("Received an empty response from the API")
                null
            }

        } catch (e: Exception) {
            println("Error fetching VPN data: ${e.message}")
            null
        }
    }

}
