package com.mustafin.cells.data.repositories

import com.mustafin.cells.domain.enums.CellStatus

// Репозиторий для работы с храненением списка клеток
interface CellsRepository {
    suspend fun getCells(result: (List<CellStatus>) -> Unit)
    fun setCells(cells: List<CellStatus>)
}