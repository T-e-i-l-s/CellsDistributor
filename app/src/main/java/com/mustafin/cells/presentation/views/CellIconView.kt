package com.mustafin.cells.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafin.cells.DEFAULT_FONT
import com.mustafin.cells.R
import com.mustafin.cells.domain.enums.CellStatus

// Иконка для блока с информацией о клетке
@Composable
fun CellIconView(status: CellStatus) {
    // emoji внутри иконки
    val icon = when (status) {
        CellStatus.DEAD -> stringResource(id = R.string.dead_cell_icon)
        CellStatus.ALIVE -> stringResource(id = R.string.alive_cell_icon)
        CellStatus.LIFE -> stringResource(id = R.string.life_cell_icon)
    }

    // цвета градиента на фоне
    val gradientColors = when (status) {
        CellStatus.DEAD -> listOf(
            colorResource(id = R.color.dead_gradient_start),
            colorResource(id = R.color.dead_gradient_end)
        )

        CellStatus.ALIVE -> listOf(
            colorResource(id = R.color.alive_gradient_start),
            colorResource(id = R.color.alive_gradient_end)
        )

        CellStatus.LIFE -> listOf(
            colorResource(id = R.color.life_gradient_start),
            colorResource(id = R.color.life_gradient_end)
        )
    }

    Box(
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .clip(CircleShape)
            .background(Brush.verticalGradient(gradientColors))
    ) {
        Text(
            text = icon,
            fontFamily = DEFAULT_FONT,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}