package com.example.vpn.presentation.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Power
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpn.R
import com.example.vpn.domain.model.vpn.VpnDataResponse
import com.example.vpn.domain.usecase.ResultState
import com.example.vpn.presentation.viewmodel.MainViewModel
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var isLoading by remember { mutableStateOf(false) }
    var vpnData by remember { mutableStateOf<VpnDataResponse?>(null) }
    val isConnected = true

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E2E3D)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BackgroundImage()
            MainContent(isConnected = isConnected)
        }
    }
}

@Composable
fun BackgroundImage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cover),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.cover),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color.LightGray.copy(0.30f))
        )
    }
}

@Composable
fun MainContent(isConnected: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()

        Spacer(modifier = Modifier.height(20.dp))

        ConnectionStatus()

        ServerInfo()

        Spacer(modifier = Modifier.height(30.dp))

        SpeedInfo()

        BottomControl(isConnected = isConnected)
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .size(40.dp)
                .background(Color(0xFF3A3A4D))
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }

        Text(
            text = "VPNite",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Image(
            painter = painterResource(id = R.drawable.premium),
            contentDescription = "Premium",
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun ConnectionStatus() {
    Text(text = "Connecting Time", fontSize = 12.sp, color = Color.LightGray)
    Text(
        text = "00:30:26",
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun ServerInfo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
            .height(90.dp)
            .border(
                BorderStroke(1.dp, color = Color.LightGray),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.flag_of_the_united_states),
                contentDescription = "Flag",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Column(
                modifier = Modifier.wrapContentHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "United States",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = "IP: 37.1.20.202.186",
                    fontSize = 13.sp,
                    color = Color.LightGray
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Change Server",
                tint = Color.White
            )
        }
    }
}

@Composable
fun SpeedInfo() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SpeedColumn("Download", "245 KB/s", Icons.Default.Download)
        SpeedColumn("Upload", "176 KB/s", Icons.Default.Upload)
    }
}

@Composable
fun SpeedColumn(label: String, speed: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = "$label Speed",
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = Color.Gray,
            fontSize = 12.sp
        )
        Text(
            text = speed,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BottomControl(isConnected: Boolean) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 110.dp, topEnd = 110.dp))
            .fillMaxWidth()
            .height(440.dp)
            .background(Color(0XFF3d3d4d)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            GlowingPowerButton()

            Spacer(modifier = Modifier.height(5.dp))

            Spacer(modifier = Modifier.weight(1f))

            ConnectionStatusRow(isConnected = isConnected)

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Composable
fun ConnectionStatusRow(isConnected: Boolean) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Security,
                contentDescription = null,
                tint = if (isConnected) Color.Green else Color.Red,
                modifier = Modifier.padding(bottom = 11.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = if (isConnected) "Connected" else "Disconnected",
                fontSize = 18.sp,
                color = if (isConnected) Color.Green else Color.Red,
                modifier = Modifier.padding(bottom = 11.dp)
            )
        }
    }

}


