package com.example.composeapp.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapp.ui.theme.ComposeAppTheme


@Composable
fun TestStyleComponent(darkTheme: Boolean) {
    ComposeAppTheme(darkTheme = darkTheme) {
        Row(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            Text(
                text = "Test text",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelMedium,
            )
            TestStyleComponent2()
        }
    }

}

@Composable
fun TestStyleComponent2() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "222Test text",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelLarge,
        )

    }
}



@Preview
@Composable
fun PreviewTestStyleComponent() {
    TestStyleComponent(darkTheme = true)
}