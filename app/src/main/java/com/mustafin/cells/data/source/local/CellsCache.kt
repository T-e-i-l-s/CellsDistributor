package com.mustafin.cells.data.source.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mustafin.cells.PREFERENCE_FILE_KEY
import com.mustafin.cells.domain.enums.CellStatus

// Класс для работы с кешем клеток
class CellsCache(context: Context) {
    // Инициализируем Shared Preferences
    private val sharedPref = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)

    // Создаем экземпляр класса Gson
    private val gson = Gson()

    // Ключ к ячейке памяти, в которой хранится список клеток
    private val cellsKey = "cells"

    // Функция, которая получает список клеток из кеша
    fun getCells(result: (List<CellStatus>) -> Unit) {
        // Получаем json списка клеток
        val json = sharedPref.getString(cellsKey, null)
        // Переводим json в List<CellStatus>
        val cells: List<CellStatus> = if (json != null) {
            val type = object : TypeToken<List<CellStatus>>() {}.type
            gson.fromJson(json, type)
        } else {
            // Если списка в кеше не было, то возвращаем пустой список
            emptyList()
        }
        // Отдаем список клеток
        result(cells)
    }

    // Функция, которая сохраняет список клеток в кещ
    fun setCells(cells: List<CellStatus>) {
        // Переводим список в json
        val json = gson.toJson(cells)
        // Сохраняем его в кеш
        sharedPref.edit()
            .putString(cellsKey, json)
            .apply()
    }
}