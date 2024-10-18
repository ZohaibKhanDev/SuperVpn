package com.example.vpn.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaqScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FAQs", color = Color.White) },
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Frequently Asked Questions")
                    },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                FaqItem(
                    question = "What is a VPN?",
                    answer = buildAnnotatedString {
                        append("A VPN (Virtual Private Network) ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Yellow
                            )
                        ) {
                            append("encrypts your internet connection")
                        }
                        append(" to secure it and protect your privacy. This makes your online actions untraceable and secure.")
                    }
                )

                FaqItem(
                    question = "How do I connect to the VPN?",
                    answer = buildAnnotatedString {
                        append("To connect to the VPN, simply open the app and ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Green
                            )
                        ) {
                            append("tap the connect button.")
                        }
                        append(" Once connected, you’ll see the connection status on the home screen.")
                    }
                )

                FaqItem(
                    question = "Can I use the VPN to access blocked websites?",
                    answer = buildAnnotatedString {
                        append("Yes, a VPN allows you to access websites and content ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Cyan
                            )
                        ) {
                            append("that may be restricted")
                        }
                        append(" in your location by masking your IP address.")
                    }
                )

                FaqItem(
                    question = "Does the VPN slow down my internet connection?",
                    answer = buildAnnotatedString {
                        append("Using a VPN might ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Red
                            )
                        ) {
                            append("slightly reduce your internet speed")
                        }
                        append(" as your traffic is routed through encrypted servers. However, our VPN is optimized to minimize any impact on your speed.")
                    }
                )

                FaqItem(
                    question = "How can I contact support?",
                    answer = buildAnnotatedString {
                        append("You can contact our support team by going to the ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Magenta
                            )
                        ) {
                            append("Settings")
                        }
                        append(" menu and selecting the ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Blue
                            )
                        ) {
                            append("‘Contact Us’")
                        }
                        append(" option. We are always here to help!")
                    }
                )
            }
        }
    )
}

@Composable
fun FaqItem(question: String, answer: AnnotatedString) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = question,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = answer,
            fontSize = 16.sp,
            color = Color.LightGray
        )
    }
}
