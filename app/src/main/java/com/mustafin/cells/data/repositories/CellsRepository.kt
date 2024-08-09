package com.mustafin.cells.data.repositories

import com.mustafin.cells.domain.enums.CellStatus

interface CellsRepository {
    suspend fun getCells(result: (List<CellStatus>) -> Unit)
    fun setCells(cells: List<CellStatus>)
}