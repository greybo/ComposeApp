package com.example.composeapp.examples

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RailComp() {
    val isShowRail = remember { mutableStateOf(false) }
    val transitionStateShow = MutableTransitionState(true)
    val modifier = if (isShowRail.value) {
        Modifier.fillMaxWidth(0.5f)
    } else Modifier.fillMaxWidth(0f)

    fun hideRail() {
        isShowRail.value = false
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Navigation Rail") },
                modifier = Modifier.shadow(4.dp, shape = RectangleShape),
                navigationIcon = {
                    Icon(
                        modifier = Modifier.clickable { isShowRail.value = true },
                        imageVector = Icons.Default.Menu,
                        contentDescription = ""
                    )
                })
        }) {
        Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {
//            AnimatedVisibility(visibleState = transitionStateShow) {
//
//            }
            NavigationRail(
                modifier = modifier,
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 10.dp,
                header = {
                    Text(text = "Header")

                }
            ) {
                RailCompItem(Icons.Default.Add, "Content 1") { hideRail() }
                RailCompItem(Icons.Default.ArrowBack, "Content 4") { hideRail() }
                RailCompItem(Icons.Default.Menu, "Content 3") { hideRail() }
            }
        }
    }

}

@Composable
fun RailCompItem(icon: ImageVector, label: String, callback: () -> Unit) {
    NavigationRailItem(
        selected = true,
        onClick = callback,
        icon = { Icon(imageVector = icon, tint = Color.Blue, contentDescription = "icon") },
        modifier = Modifier,
        enabled = true,
        label = { Text(text = label) },
        alwaysShowLabel = true,
//    interactionSource: MutableInteractionSource,
        selectedContentColor = Color.Gray,
        unselectedContentColor = Color.Red
    )
}