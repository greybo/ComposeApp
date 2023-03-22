package com.example.composeapp.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NestedScroll() {
// here we use LazyColumn that has build-in nested scroll, but we want to act like a
// parent for this LazyColumn and participate in its nested scroll.
// Let's make a collapsing toolbar for LazyColumn
    val toolbarHeight = 48.dp
    val collapseHeight = 200.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
    val collapseHeightPx = with(LocalDensity.current) { collapseHeight.roundToPx().toFloat() }
// our offset to collapse toolbar
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
    val collapseHeightDp = with(LocalDensity.current) { collapseHeightPx.toDp() }
    val toolbarOffsetHeightDp = with(LocalDensity.current) { toolbarOffsetHeightPx.value.toDp() }

// now, let's create connection to the nested scroll system and listen to the scroll
// happening inside child LazyColumn
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-collapseHeightPx, 0f)
                // here's the catch: let's pretend we consumed 0 in any case, since we want
                // LazyColumn to scroll anyway for good UX
                // We're basically watching scroll without taking it
                return Offset.Zero
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {

        // our list with build in nested scroll support that will notify us about its scroll
        Column() {
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .height(toolbarOffsetHeightDp)
                    .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) }
//                    .scale(
//                        scaleX = 1f,
//                        scaleY =0.5F //1 - ((1 / collapseHeightPx) * toolbarOffsetHeightPx.value)
//                    )
                ,
                contentAlignment = Alignment.Center,
                content = {
                    val painter = painterResource(id = R.drawable.profile_picture)

                    Image(
                        painter = painter,
                        contentDescription = "Icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1080 / collapseHeightPx)
                            .fillMaxSize()

                    )
                    Text(
                        text = "toolbar offset is ${toolbarOffsetHeightPx.value}",
                        fontSize = 20.sp,
                        color = Color.White
                    )

                }
            )
            LazyColumn(contentPadding = PaddingValues(top = toolbarOffsetHeightDp)) {
                items(100) { index ->
                    Text(
                        "I'm item $index", modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
//                    Pointer(
//                        scale = 1f,
//                        modifier = Modifier
//                            .background(Color.Magenta)
//                            .padding(25.dp)
////                            .preferredSize(50.dp)
//                            .align(Alignment.CenterHorizontally)
//                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewNestedScroll() {
    NestedScroll()
}