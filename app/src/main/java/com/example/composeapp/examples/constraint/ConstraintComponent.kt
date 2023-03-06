package com.example.composeapp.examples.constraint

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composeapp.R


@Composable
fun SearchResults(
    searchResults: List<Snack>,
    filters: List<Filter>,
    onSnackClick: (Long) -> Unit
) {
    Column {
        FilterBar(filters, onShowFilters = {})
       Text(
            text = stringResource(R.string.search_count, searchResults.size),
            style = MaterialTheme.typography.bodyLarge,
            color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
        )
        LazyColumn {
            itemsIndexed(searchResults) { index, snack ->
                SearchResult(snack, onSnackClick, index != 0)
            }
        }
    }
}

@Composable
private fun SearchResult(
    snack: Snack,
    onSnackClick: (Long) -> Unit,
    showDivider: Boolean,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSnackClick(snack.id) }
            .padding(horizontal = 24.dp)
    ) {
        val (divider, image, name, tag, priceSpacer, price, add) = createRefs()
        createVerticalChain(name, tag, priceSpacer, price, chainStyle = ChainStyle.Packed)
        if (showDivider) {
            AppDivider(
                Modifier.constrainAs(divider) {
                    linkTo(start = parent.start, end = parent.end)
                    top.linkTo(parent.top)
                }
            )
        }
//        SnackImage(
//            imageUrl = snack.imageUrl,
//            contentDescription = null,
//            modifier = Modifier
//                .size(100.dp)
//                .constrainAs(image) {
//                    linkTo(
//                        top = parent.top,
//                        topMargin = 16.dp,
//                        bottom = parent.bottom,
//                        bottomMargin = 16.dp
//                    )
//                    start.linkTo(parent.start)
//                }
//        )
        Text(
            text = snack.name,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.constrainAs(name) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = add.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        Text(
            text = snack.tagline,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(tag) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = add.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        Spacer(
            Modifier
                .height(8.dp)
                .constrainAs(priceSpacer) {
                    linkTo(top = tag.bottom, bottom = price.top)
                }
        )
        Text(
            text = "formatPrice(snack.price)",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.constrainAs(price) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = add.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        Button(
            onClick = { /* todo */ },
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .size(36.dp)
                .constrainAs(add) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = stringResource(R.string.label_add)
            )
        }
    }
}
