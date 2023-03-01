package com.example.composeapp.examples.constraint

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints() {
        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(
            constraintSet = constraints,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            start.linkTo(parent.start, margin = margin)
            top.linkTo(parent.top, margin = margin)
//            scaleX = 1.5f
//            scaleY = 1.5f
        }
        constrain(text) {
            bottom.linkTo(button.bottom, margin = margin)
//            start.linkTo(button.end, margin = margin)
            end.linkTo(parent.end, margin = margin)
        }
    }
}

@Preview
@Composable
fun ChartDataPreview() {
    MaterialTheme {
//        ConstraintLayoutContent( )
        DecoupledConstraintLayout()
    }
}