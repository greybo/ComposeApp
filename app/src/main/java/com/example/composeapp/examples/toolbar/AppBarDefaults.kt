package com.example.composeapp.examples.toolbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ActionToolbar(val icon: ImageVector, val color: Color?, val action: () -> Unit)
data class ColorToolbar(
    val backgroundColor: Color = Color.White,
    val contentColor: Color = Color.Black
)

fun toolbarColorDefault(
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black
): ColorToolbar {
    return ColorToolbar(backgroundColor, contentColor)
}

fun homeActionDefault(
    icon: ImageVector = Icons.Default.ArrowBack,
    color: Color? = null,
    action: () -> Unit = {}
): ActionToolbar {
    return ActionToolbar(icon = icon, color = color, action)
}

fun rightActionDefault(
    icon: ImageVector = Icons.Default.Menu,
    color: Color? = null,
    action: () -> Unit = {}
): ActionToolbar {
    return ActionToolbar(icon = icon, color = color, action)
}