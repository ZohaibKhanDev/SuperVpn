package com.example.vpn.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF2E2E3D))
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF2E2E3D))
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Privacy Policy",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                PrivacyPolicyContent()
            }
        }
    )
}

@Composable
fun PrivacyPolicyContent() {
    val privacyPolicyText = buildAnnotatedString {
        append("At Super VPN, your privacy is important to us. This privacy policy explains how we collect, use, and protect your personal information when you use our VPN services.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("1. Information We Collect\n")
        }
        append("We do not collect any personal information that can identify you. However, we may collect anonymous data such as your app usage, connection logs, and device information to improve the quality of our service.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("2. How We Use Your Information\n")
        }
        append("The data we collect is used to optimize our app performance, monitor network quality, and provide a secure connection to our servers. Your data is never sold or shared with third parties for advertising purposes.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("3. Third-Party Services\n")
        }
        append("We may work with third-party services, such as analytics providers, to help us understand and improve our app's performance. These third parties may have access to anonymous data, but they are required to keep this data secure and confidential.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("4. Security\n")
        }
        append("We implement strong security measures to protect your data from unauthorized access or disclosure. Our encryption technology ensures your internet connection is secure and private.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("5. User Rights\n")
        }
        append("As a user of Super VPN, you have the right to:\n")
        append("• Access and review the information we collect.\n")
        append("• Request the deletion of any data associated with your use of our app.\n")
        append("• Opt out of data collection for analytics purposes.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("6. Changes to This Privacy Policy\n")
        }
        append("We reserve the right to update this privacy policy at any time. Any changes will be reflected in this document, and you will be notified of significant changes via in-app notifications.\n\n")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        ) {
            append("7. Contact Us\n")
        }
        append("If you have any questions about this privacy policy or your data, please contact us at support@supervpn.com.\n\n")

        append("Last Updated: October 2024")
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = privacyPolicyText,
            fontSize = 16.sp,
            color = Color.LightGray
        )
    }
}
