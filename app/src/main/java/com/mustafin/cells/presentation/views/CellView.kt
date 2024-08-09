package com.mustafin.cells.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafin.cells.DEFAULT_FONT
import com.mustafin.cells.R
import com.mustafin.cells.domain.enums.CellStatus

// Элемент с информацией о клетке
@Composable
fun CellView(status: CellStatus = CellStatus.DEAD) {
    // Заголовок
    val title = when (status) {
        CellStatus.DEAD -> stringResource(id = R.string.dead_cell_title)
        CellStatus.ALIVE -> stringResource(id = R.string.alive_cell_title)
        CellStatus.LIFE -> stringResource(id = R.string.life_cell_title)
    }

    // Дополнителный текст
    val text = when (status) {
        CellStatus.DEAD -> stringResource(id = R.string.dead_cell_text)
        CellStatus.ALIVE -> stringResource(id = R.string.alive_cell_text)
        CellStatus.LIFE -> stringResource(id = R.string.life_cell_text)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.main_fill))
            .padding(16.dp)
    ) {
        CellIconView(status)
        Column (modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = title,
                fontFamily = DEFAULT_FONT,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.dark_text)
            )
            Text(
                text = text,
                fontFamily = DEFAULT_FONT,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.dark_text)
            )
        }
    }
}