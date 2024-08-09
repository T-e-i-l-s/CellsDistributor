package com.mustafin.cells.domain

import android.content.Context
import com.mustafin.cells.data.repositories.CellsRepositoryImpl
import com.mustafin.cells.domain.enums.CellStatus
import kotlin.random.Random

// Класс, который управляет списком и статусом клеток
class CellsManager(context: Context) {
    // Репозиторий для работы с хранением данных о ячейках
    private val repository = CellsRepositoryImpl(context)

    // Функция, для получения списка клеток
    suspend fun getCells(result: (List<CellStatus>) -> Unit) {
        repository.getCells {
            result(it)
        }
    }

    // Функция, добавления и обработки новой клетки
    fun addCell(cells: List<CellStatus>): List<CellStatus> {
        // Генерируем случайное Boolean значение и переводим его в DEAD или ALIVE
        val newCellStatus = generateRandomCellStatus()

        // Создание нового списка с добавленным элементом
        var updatedCells = cells + newCellStatus

        // Применение правил для обновленного списка клеток
        updatedCells = applyRules(updatedCells.toMutableList())

        // Сохраняем в кеш
        repository.setCells(updatedCells)
        // Отдаем обновленный список
        return updatedCells
    }

    // Генерация случайного статуса клетки
    private fun generateRandomCellStatus(): CellStatus {
        return if (Random.nextBoolean()) CellStatus.DEAD else CellStatus.ALIVE
    }

    // Применение правил обработки списка клеток
    private fun applyRules(cells: MutableList<CellStatus>): List<CellStatus> {
        applyAliveRule(cells)
        applyDeadRule(cells)
        return cells
    }

    // Правило: Добавление жизни при 3 живых клетках подряд
    private fun applyAliveRule(cells: MutableList<CellStatus>) {
        if (cells.size >= 3 && cells.takeLast(3).all { it == CellStatus.ALIVE }) {
            // Если 3 живых клетки подряд -> создаем жизнь
            cells += CellStatus.LIFE
        }
    }

    // Правило: Замена клетки при 3 мертвых клетках подряд
    private fun applyDeadRule(cells: MutableList<CellStatus>) {
        if (cells.size >= 4 && cells.takeLast(3).all { it == CellStatus.DEAD }) {
            // Если 3 мертвых клетки подряд -> делаем клетку рядом мертвой
            cells[cells.size - 4] = CellStatus.DEAD
        }
    }
}