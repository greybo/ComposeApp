package com.example.composeapp.examples.elements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class ToolbarModel(
    val title: String = "My Costs",
    val homeAction: (() -> Unit)? = { },
    val rightAction: (() -> Unit)? = {}
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarAppComponent(model: ToolbarModel = ToolbarModel()) {
    TopAppBar(
        title = {
            Text(model.title, fontSize = 22.sp)
        },
        navigationIcon = {
            model.homeAction?.let {
                IconButton(onClick = {
                    it.invoke()
                }) { Icon(Icons.Default.ArrowBack, contentDescription = "Home") }
            }

        },
        actions = {
//            Spacer(Modifier)
            model.rightAction?.let {
                IconButton(onClick = {
                    it.invoke()
                }) { Icon(Icons.Filled.Menu, contentDescription = "Menu") }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.White),
        modifier = Modifier.shadow(4.dp, shape = RectangleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewToolbar() {
    ToolbarAppComponent(ToolbarModel("META-NIT.COM", {}, {}))
}