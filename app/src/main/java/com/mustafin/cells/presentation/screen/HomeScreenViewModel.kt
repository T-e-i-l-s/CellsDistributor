package com.mustafin.cells.presentation.screen

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mustafin.cells.domain.CellsManager
import com.mustafin.cells.domain.enums.CellStatus
import kotlinx.coroutines.launch

// ViewModel для главного экрана
class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    // Список всех клеток
    var cells by mutableStateOf(listOf<CellStatus>())
        private set

    // Класс для хранения данных о клетках
    private val cellsManager = CellsManager(application.baseContext)

    init {
        // При создании ViewModel получаем из кеша список клеток
        viewModelScope.launch {
            cellsManager.getCells {
                cells = it
            }
        }
    }

    // Функция, которая добавляет клетку
    fun addCell() {
        cells = cellsManager.addCell(cells)
        println(cells)
    }
}