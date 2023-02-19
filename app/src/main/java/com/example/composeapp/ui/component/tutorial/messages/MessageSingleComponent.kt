package com.example.composeapp.ui.component.tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.R
import com.example.composeapp.ui.component.tutorial.messages.MessageViewModel


@Composable
fun MessageSingle(viewModel: MessageViewModel = viewModel()) {

    val state by viewModel.uiState.collectAsState()

    MessageCardSingle(state.author, state.body) {
        viewModel.changeData()
    }
}

@Composable
fun MessageCardSingle(author: String, body: String, callback: () -> Unit) {

    Row(modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 0.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                // Set image size to 40 dp
                .size(60.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(2.dp, Color.Green /*MaterialTheme.colorScheme.secondary*/, CircleShape)
                .clickable {
                    callback()
                }
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageSingle() {
    MessageSingle()
}

