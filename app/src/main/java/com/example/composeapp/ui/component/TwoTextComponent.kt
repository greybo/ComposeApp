package com.example.composeapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun twoText(name: String) {
    Column(
        horizontalAlignment = Alignment.End
//        modifier = Modifier
//            .background(Color.Red)
//            .padding(16.dp)

    ) {
        Text(
            text = "Hello $name",
            color = Color.Green,
            fontSize = 40.sp
        )
        Text(
            text = "Some other text",
            color = Color.Red,
            fontSize = 24.sp,
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.Green)
//                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        twoText("Android")
    }
}