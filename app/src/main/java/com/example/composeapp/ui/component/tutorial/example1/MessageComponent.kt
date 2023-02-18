package com.example.composeapp.ui.component.tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.R


@Composable
fun MessageCard(viewModel: MessageViewModel = viewModel()) {

    val state by viewModel.uiState.collectAsState()

    Row {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .padding(8.dp, 8.dp, 0.dp, 0.dp)
                .clickable {
                    viewModel.changeData()
                },
            colorFilter = ColorFilter.tint(color = Color.Red, BlendMode.ColorBurn)
        )
        Column {
            Text(
                text = state.author,
                modifier = Modifier.padding(8.dp),
                fontSize = 24.sp,
                color = Color.Black
            )
            Text(
                text = state.body,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard()
}

