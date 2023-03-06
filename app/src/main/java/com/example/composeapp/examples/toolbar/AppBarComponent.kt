package com.example.composeapp.examples.toolbar

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarComponent(
    title: String = "My Costs",
    homeAction: ActionToolbar? = homeActionDefault(),
    rightAction: ActionToolbar? = rightActionDefault(),
    colorsDefault: ColorToolbar = toolbarColorDefault()
) {
    TopAppBar(
        title = {
            Text(title, fontSize = 22.sp)
        },
        navigationIcon = {
            homeAction?.let {
                IconButton(onClick = {
                    it.action.invoke()
                }) { Icon(it.icon, contentDescription = "Home") }
            }

        },
        actions = {
//            Spacer(Modifier)
            rightAction?.let {
                IconButton(onClick = {
                    it.action.invoke()
                }) { Icon(it.icon, contentDescription = "Menu") }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorsDefault.backgroundColor,
            titleContentColor = colorsDefault.contentColor,
            navigationIconContentColor = homeAction?.color ?: colorsDefault.contentColor,
            actionIconContentColor = rightAction?.color ?: colorsDefault.contentColor
        ),
        modifier = Modifier.shadow(4.dp, shape = RectangleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewToolbar() {
    AppBarComponent(
//        rightAction = null,
//        colorsDefault = toolbarColorDefault(Color.Blue, Color.White)
    )
}