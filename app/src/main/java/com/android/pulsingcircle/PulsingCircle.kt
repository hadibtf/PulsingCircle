package com.android.pulsingcircle

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PulsingCircle(modifier: Modifier = Modifier) {
    val animationPeriod = 2000
    val animationDelayFraction = animationPeriod / 8L
    val circlesQuantity = 40

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val height = maxHeight.value.absoluteValue
        val initialPulsingCircleRadius = height / 4.5f

        for (i in 0..7) {
            val currentStepDelayPeriod = i * animationDelayFraction
            val circleColorAlpha = remember { Animatable(1.0f) }
            val targetPulsingCircleRadius = remember { Animatable(initialPulsingCircleRadius) }

            LaunchedEffect(Unit) {
                delay(currentStepDelayPeriod)
                targetPulsingCircleRadius.animateTo(
                    height,
                    infiniteRepeatable(tween(animationPeriod, easing = LinearEasing))
                )
            }

            LaunchedEffect(Unit) {
                delay(currentStepDelayPeriod)
                circleColorAlpha.animateTo(0.0f, infiniteRepeatable(tween(animationPeriod)))
            }

            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val centerX = canvasWidth / 2
                val centerY = canvasHeight / 2
                val circleRadius = height / 4
                drawCircle(Color.Black, circleRadius, Offset(centerX, centerY), style = Fill)
            }

            Canvas(modifier = Modifier.fillMaxSize()) {
                val centerX = size.width / 2
                val centerY = size.height / 2
                val miniCirclesRadius = height / 50
                repeat(circlesQuantity) { index ->
                    val angle = (2 * PI / circlesQuantity) * index
                    val x = centerX + cos(angle) * targetPulsingCircleRadius.value
                    val y = centerY + sin(angle) * targetPulsingCircleRadius.value
                    drawCircle(
                        Color.Black.copy(alpha = circleColorAlpha.value),
                        miniCirclesRadius,
                        Offset(x.toFloat(), y.toFloat()),
                        style = Fill
                    )
                }
            }
        }
    }
}