package com.mustafin.cells.data.repositories

import com.mustafin.cells.domain.enums.CellStatus

// Репозиторий для работы с храенением списка клеток
class CellsRepositoryImpl: CellsRepository {
    // Получить список клеток
    override fun getCells(result: (List<CellStatus>) -> Unit) {
        TODO("Not yet implemented")
    }

    // Обновить список клеток
    override fun setCells(cells: List<CellStatus>) {
        TODO("Not yet implemented")
    }
}