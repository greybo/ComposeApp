//package com.example.composeapp.carousel
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.core.math.MathUtils
//import java.lang.Math.abs
//
//@Composable
//fun CardCarouselComponent() {
//
//    val dragFraction = abs(dragAmountX).div(screenWidth / 2).coerceIn(0f, 1f)
//    val dragFractionWRTScreen = abs(dragAmountX).div(screenWidth).coerceIn(0f, 1f)
//
//    //Only the top item should be removed from deck otherwise it will not respond
//    val dragState = listOfDragState[dragIndex]
////Linear interpolating the card itself opacity
////if dragging the card towards left side then it will be fade out
//    val opacity = MathUtil.lerp(0f,1f,dragFractionWRTScreen)
//    MathUtils.
//    dragState.snap(opacityP = opacity, offsetXP = dragAmountX)
//
//    val dragManager = dragState?:rememberDragManager(size = items.size, maxCards = maxElements, scope = scope)
//
//    for ((counter, i) in (dragIndex - 1 downTo (dragIndex - maxCards + 1).coerceAtLeast(0)).withIndex()) {
//        val startIndex = counter + 1
//        val endIndex = counter
//        val scaleP =
//            MathUtil.lerp(
//                scale[startIndex],
//                scale[endIndex],
//                abs(dragFraction)
//            )
//        val opacityP =
//            MathUtils.lerp(
//                opacity[startIndex],
//                opacity[endIndex],
//                abs(dragFraction)
//            )
//        val offsetXP =
//            MathUtil.lerp(offsetX[startIndex], offsetX[endIndex], abs(dragFraction))
//        launch {
//            listOfDragState[i].snap(
//                scaleP = scaleP,
//                opacityP = opacityP,
//                offsetXP = offsetXP
//            )
//        }
//    }
//
//    items
//        .asReversed()
//        .forEachIndexed { index, item ->
//            if (dragManager.listOfDragState.isNotEmpty()) {
//                val swipeState = dragManager.listOfDragState[index]
//                if (index in visibleIndexRange) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .graphicsLayer {
//                                scaleY = swipeState.scale.value
//                                scaleX = swipeState.scale.value
//                                translationX = swipeState.offsetX.value
//                                alpha = 1f - swipeState.opacity.value
//                            }
//                            .clip(shape = cornerShape)
//                            .shadow(elevation = elevation, shape = cornerShape),
//                    ) {
//                        Box(modifier = Modifier.fillMaxSize()) {
//                            content(item)
//                        }
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .alpha(alpha = swipeState.opacity.value)
//                                .background(color = Color.White , shape = cornerShape)
//                        )
//                    }
//                }
//            }
//        }
//
//    val visibleIndexRange =
//        (items.size - 1 downTo(dragManager.topDeckIndex.value - maxElements).coerceAtLeast(0)).map { it }
//}
//
//
//val items = mutableListOf<String>()