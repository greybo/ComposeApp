package com.example.composeapp.examples

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ShrineApp() {
    BoxWithConstraints(
        Modifier.fillMaxSize()
    ) {
        Backdrop(
            showScrim = sheetState == CartBottomSheetState.Expanded,
            onAddCartItem = {
                if (cartItems.isEmpty()) firstAddCartItem = it
                cartItems.add(it.data)
            },
            onBackdropReveal = { revealed ->
                sheetState =
                    if (revealed) CartBottomSheetState.Hidden else CartBottomSheetState.Collapsed
            }
        )
    }
}