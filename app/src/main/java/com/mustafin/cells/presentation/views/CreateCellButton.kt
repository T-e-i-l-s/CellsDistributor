package com.mustafin.cells.presentation.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafin.cells.DEFAULT_FONT
import com.mustafin.cells.R

// Кнопка "Сотворить"
@Composable
fun CreateCellButton(modifier: Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.additional)),
        contentPadding = PaddingValues(10.dp),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
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