package com.example.composeapp.carousel

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Math.abs

open class DragState(
    val index: Int,
    val screenWidth: Float,
    private val scope: CoroutineScope,
    private val animationSpec: AnimationSpec<Float>
) {

    var opacity = Animatable(1f)
        private set

    var offsetX = Animatable(0f)
        private set
    var offsetY = Animatable(0f)
        private set
    var scale = Animatable(0f)
        private set

    private val dragFraction = mutableStateOf(0f)

    suspend fun drag(dragAmountX: Float, dragAmountY: Float,onParallel: suspend () -> Unit = {}) = scope.launch {

        dragFraction.value = abs(dragAmountX).div(screenWidth).coerceIn(0f, 1f)
        launch {
            offsetX.snapTo(dragAmountX)
        }
        launch {
            onParallel()
        }
    }

    fun positionToCenter(onParallel: suspend () -> Unit = {}) = scope.launch {
        launch { offsetX.animateTo(0f, animationSpec = animationSpec) }
        launch { offsetY.animateTo(0f, animationSpec = animationSpec) }
        launch { onParallel() }
    }

    fun animateOutsideOfScreen(onParallel: suspend () -> Unit = {}) = scope.launch {
        launch {
            offsetX.animateTo(-screenWidth, animationSpec = animationSpec)
        }
        launch {
            onParallel()
        }
    }

    suspend fun snap(scaleP: Float = 1f, opacityP: Float = 1f, offsetXP: Float = 0f) = scope.launch {
        launch { scale.snapTo(scaleP) }
        launch { opacity.snapTo(opacityP) }
        launch { offsetX.snapTo(offsetXP) }
    }

    suspend fun animateTo(
        scaleP: Float = 1f,
        opacityP: Float = 1f,
        offsetXP: Float = 0f,
        onParallel: suspend () -> Unit = {}
    ) = scope.launch {
        launch { scale.animateTo(scaleP, animationSpec = animationSpec) }
        launch { opacity.animateTo(opacityP, animationSpec = animationSpec) }
        launch { offsetX.animateTo(offsetXP, animationSpec = animationSpec) }
        launch { onParallel() }
    }

}