package com.example.vpn.presentation.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.vpn.domain.model.vpn.VpnDataResponseItem

@Composable
fun GlowingPowerButton() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .graphicsLayer {
                scaleX = 1.2f
                scaleY = 1.2f
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawConcentricCircles(this)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFF494673), Color(0xFF2A2A44)),
                        radius = 500f
                    ),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.PowerSettingsNew,
                contentDescription = "Power Button",
                tint = Color(0xFFFFA726),
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

fun drawConcentricCircles(drawScope: DrawScope) {
    val circleColors = listOf(
        Color(0xFFFFA726).copy(alpha = 0.4f),
        Color(0xFFFFA726).copy(alpha = 0.2f),
        Color(0xFFFFA726).copy(alpha = 0.1f)
    )

    circleColors.forEachIndexed { index, color ->
        val radiusInPx = with(drawScope) { 70.dp.toPx() - (index * 20.dp.toPx()) }
        val strokeWidthInPx = with(drawScope) { 3.dp.toPx() }

        drawScope.drawCircle(
            color = color,
            radius = radiusInPx,
            style = Stroke(width = strokeWidthInPx, cap = StrokeCap.Round)
        )
    }
}

