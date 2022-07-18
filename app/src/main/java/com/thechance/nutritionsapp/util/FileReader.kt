package com.thechance.nutritionsapp.util

import com.thechance.nutritionsapp.NutritionApp
import java.io.BufferedReader
import java.io.InputStreamReader


class FileReader(private var fileName: String) {

    fun getLinesFromFile(): List<String> {
        val lines = mutableListOf<String>()
        val inputStream = InputStreamReader(
            NutritionApp.applicationContext().assets.open(fileName))
        val buffer = BufferedReader(inputStream)
        buffer.forEachLine { line -> lines.add(line) }
        return lines
    }

}