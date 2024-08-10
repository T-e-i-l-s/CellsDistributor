package com.mustafin.cells

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mustafin.cells.domain.CellsManager
import com.mustafin.cells.domain.enums.CellStatus
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

/**
 * Unit-тесты, которые проверяют верность реализации класса CellsManager
 * Рассматриваются ситуации:
 * - Добавление клетки в пустой список
 * - Добавление клетки в существующий список
 * - 3 живых клетки
 * - 3 мертвых клетки и живая рядом
 * - 3 мертвых клетки и жизнь рядом
 * - 3 мертвых клетки и мертвая рядом
 * - 3 мертвых клетки и нет клеток рядом
 */
@RunWith(AndroidJUnit4::class)
class CellsManagerUnitTest {
    // получение контекста приложения
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val cellsManager = CellsManager(context) // Экземпляр тестируемого класса

    /*
     * Добавление клетки в пустой список.
     * На вход функции addCell отдается пустой список.
     * Должен вернуться список из 1 элемента ALIVE или DEAD.
     */
    @Test
    fun addCellToEmptyList() {
        val result = cellsManager.addCell(emptyList())
        assertTrue(result == listOf(CellStatus.DEAD) || result == listOf(CellStatus.ALIVE))
    }

    /*
     * Добавление клетки в существующий список.
     * На вход функции addCell отдается список из нескольких элементов DEAD, ALIVE или LIFE.
     * Должен вернуться список, который повторяет входной, но с элементом ALIVE или DEAD в конце.
     */
    @Test
    fun addCellToList() {
        val defaultList = listOf(CellStatus.DEAD, CellStatus.LIFE, CellStatus.DEAD)
        val result = cellsManager.addCell(defaultList)
        assertTrue(
            result == defaultList + CellStatus.DEAD ||
                    result == defaultList + CellStatus.ALIVE
        )
    }

    /*
     * 3 живых клетки.
     * На вход функции, которая проверяет псписок на соответствие правилам подается список из 3 ALIVE.
     * Должен вернуться список, который повторяет входной, но с элементом LIFE в конце.
     */
    @Test
    fun threeAlive() {
        val defaultList = mutableListOf(CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE)
        val result = cellsManager.applyRules(defaultList)
        assertEquals(
            mutableListOf(CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.ALIVE, CellStatus.LIFE),
            result
        )
    }

    /*
     * 3 мертвых клетки и живая рядом
     * На вход функции, которая проверяет псписок на соответствие правилам подается
     * список из ALIVE и 3 DEAD после.
     * Должен вернуться список, который повторяет входной, но с вместо ALIVE должен появиться DEAD.
     */
    @Test
    fun threeDeadAfterAlive() {
        val defaultList =
            mutableListOf(CellStatus.ALIVE, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD)
        val result = cellsManager.applyRules(defaultList)
        assertEquals(
            mutableListOf(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD),
            result
        )
    }

    /*
     * 3 мертвых клетки и жизнь рядом
     * На вход функции, которая проверяет псписок на соответствие правилам подается
     * список из LIFE и 3 DEAD после.
     * Должен вернуться список, который повторяет входной, но с вместо LIFE должен появиться DEAD.
     */
    @Test
    fun threeDeadAfterLife() {
        val defaultList =
            mutableListOf(CellStatus.LIFE, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD)
        val result = cellsManager.applyRules(defaultList)
        assertEquals(
            mutableListOf(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD),
            result
        )
    }

    /*
     * 3 мертвых клетки и мертвая рядом
     * На вход функции, которая проверяет псписок на соответствие правилам подается
     * список из 3 DEAD.
     * Должен вернуться список, который повторяет входной.
     */
    @Test
    fun threeDeadAfterDead() {
        val defaultList =
            mutableListOf(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD)
        val result = cellsManager.applyRules(defaultList)
        assertEquals(defaultList, result)
    }

    /*
     * 3 мертвых клетки в начале списка
     * На вход функции, которая проверяет псписок на соответствие правилам подается
     * список из 3 DEAD.
     * Должен вернуться список, который повторяет входной.
     */
    @Test
    fun threeDeadAfterNone() {
        val defaultList =
            mutableListOf(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD)
        val result = cellsManager.applyRules(defaultList)
        assertEquals(
            mutableListOf(CellStatus.DEAD, CellStatus.DEAD, CellStatus.DEAD),
            result
        )
    }
}