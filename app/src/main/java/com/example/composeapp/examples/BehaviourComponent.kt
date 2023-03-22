package com.example.composeapp.examples

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BehaviourComponent() {

//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(

                title = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.profile_picture),
//                        contentDescription = "Icon",
////                        contentScale = scale.scaleType,
//                        modifier = Modifier
////                            .onPlaced {
////                                it.
////                            }
//                            .fillMaxWidth()
//                            .height(100.dp)
//                    )
                        Text(text = "Title"/*, modifier = Modifier.firstBaselineToTop(32.dp)*/)
                },
                scrollBehavior = scrollBehavior,
            )
        },
        content = {
            LazyColumn(modifier = Modifier.padding(top = it.calculateTopPadding())) {
                items(count = 20) { index ->
                    Text(
                        text = "Item $index",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    )

}

@Composable
fun MyBasicColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each children
            measurable.measure(constraints)
        }

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Track the y co-ord we have placed children up to
            var yPosition = 0

            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun PreviewBehaviourComponent() {
    MyBasicColumn() {
//        Text(text = "T1111111")
        BehaviourComponent()
    }
//    BehaviourComponent()
}