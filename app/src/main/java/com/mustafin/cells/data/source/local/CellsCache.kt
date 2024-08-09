package com.mustafin.cells.data.source.local

import android.content.Context
import com.mustafin.cells.domain.enums.CellStatus
import kotlinx.coroutines.delay

// Класс для работы с кешем клеток
class CellsCache(context: Context) {
    suspend fun getCells(result: (List<CellStatus>) -> Unit) {
        delay(1000) // Эмитируем задержку при получении кеша
        result(mutableListOf())
    }
}