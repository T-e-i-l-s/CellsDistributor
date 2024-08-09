package com.mustafin.cells.data.repositories

import android.content.Context
import com.mustafin.cells.data.source.local.CellsCache
import com.mustafin.cells.domain.enums.CellStatus

// Репозиторий для работы с храенением списка клеток
class CellsRepositoryImpl(context: Context): CellsRepository {
    // Создаем экземпляр класса для работы с кешем
    private val cellsCache = CellsCache(context)

    // Получить список клеток
    override suspend fun getCells(result: (List<CellStatus>) -> Unit) {
        cellsCache.getCells {
            result(it)
        }
    }

    // Обновить список клеток
    override fun setCells(cells: List<CellStatus>) {
        cellsCache.setCells(cells)
    }
}