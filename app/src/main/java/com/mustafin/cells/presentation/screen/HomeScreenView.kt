package com.mustafin.cells.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mustafin.cells.DEFAULT_FONT
import com.mustafin.cells.R
import com.mustafin.cells.presentation.views.CellView
import com.mustafin.cells.presentation.views.CreateCellButton

// View главного экрана
@Composable
fun HomeScreenView() {
    // Создаем ViewModel для этого View
    val viewModel: HomeScreenViewModel = viewModel()
    // Состояние LazyColumn
    val listState = rememberLazyListState()

    // Автоматический скролл в конец при добавлении нового элемента
    LaunchedEffect(viewModel.cells.size) {
        listState.scrollToItem(viewModel.cells.size)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        colorResource(id = R.color.background_gradient_start),
                        colorResource(id = R.color.background_gradient_end)
                    )
                )
            )
    ) {
        if (viewModel.cells.isEmpty()) {
            Text(
                text = stringResource(id = R.string.empty),
                fontFamily = DEFAULT_FONT,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.light_text),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.header),
                    fontFamily = DEFAULT_FONT,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.light_text),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
            items(viewModel.cells) { status ->
                CellView(status)
                Spacer(modifier = Modifier.height(4.dp))
            }
            item {
                Spacer(modifier = Modifier.height(72.dp))
            }
        }

        CreateCellButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) { viewModel.addCell() }
    }
}