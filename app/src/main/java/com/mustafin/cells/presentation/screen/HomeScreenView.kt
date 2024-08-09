package com.mustafin.cells.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

// View главного экрана
@Composable
fun HomeScreenView() {
    // Создаем ViewModel для этого View
    val viewModel: HomeScreenViewModel = viewModel()

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
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
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

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.additional)),
            contentPadding = PaddingValues(10.dp),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.create_cell_button_text),
                fontFamily = DEFAULT_FONT,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.light_text)
            )
        }
    }
}