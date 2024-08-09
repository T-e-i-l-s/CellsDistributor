package com.mustafin.cells.presentation.screen

import androidx.lifecycle.ViewModel
import com.mustafin.cells.domain.enums.CellStatus

// ViewModel для главного экрана
class HomeScreenViewModel : ViewModel() {
    // Список всех клеток
    var cells = mutableListOf(
        CellStatus.DEAD,
        CellStatus.ALIVE,
        CellStatus.LIFE,
        CellStatus.DEAD,
        CellStatus.ALIVE,
    )
        private set
}