package com.example.composeapp.examples.corousel2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import java.lang.Math.abs


val list = listOf("q", "w", "e", "r")

val maxWidth = 250.dp

@Composable
fun VerticalPagerCarouserMain() {
    Carousel(
        count = list.size,
//        parentModifier = Modifier.fillMaxSize(),
        contentWidth = maxWidth,
        contentHeight = 200.dp,
        content = { modifier, index ->
            MyComposableContent(
                item = list[index],
                modifier = modifier
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyComposableContent(item: String, modifier: Modifier) {
    Card(
        onClick = { /*TODO*/ },
        modifier = modifier,
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text(text = item)
    }
}

@Composable
fun Carousel(
    count: Int,
    parentModifier: Modifier = Modifier.fillMaxWidth().height(500.dp),
    contentWidth: Dp,
    contentHeight: Dp,
    content: @Composable (modifier: Modifier, index: Int) -> Unit
) {
    val listState = rememberLazyListState(Int.MAX_VALUE / 2)

    BoxWithConstraints(
        modifier = parentModifier
    ) {
        val halfRowWidth = constraints.maxWidth / 2

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(-contentHeight / 2),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = Int.MAX_VALUE,
                itemContent = { globalIndex ->
                    val scale = remember {
                        derivedStateOf {
                            val currentItem = listState.layoutInfo.visibleItemsInfo.firstOrNull { it.index == globalIndex } ?: return@derivedStateOf 0.85f

                            (1f - minOf(1f, abs(currentItem.offset + (currentItem.size / 2) - halfRowWidth).toFloat() / halfRowWidth) * 0.25f)
                        }
                    }

                    content(
                        index = globalIndex % count,
                        modifier = Modifier
                            .width(contentWidth)
                            .height(contentHeight)
                            .scale(scale.value)
                            .zIndex(scale.value * 10)
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewVerticalPagerCarouserMain() {
    VerticalPagerCarouserMain()
}