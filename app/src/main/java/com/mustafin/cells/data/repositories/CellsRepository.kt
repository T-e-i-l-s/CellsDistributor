package com.mustafin.cells.data.repositories

import com.mustafin.cells.domain.enums.CellStatus

interface CellsRepository {
    fun getCells(result: (List<CellStatus>) -> Unit)
    fun setCells(cells: List<CellStatus>)
}