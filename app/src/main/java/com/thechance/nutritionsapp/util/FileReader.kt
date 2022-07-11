package com.thechance.nutritionsapp.util

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

class FileReader(private var context: Context, private var fileName: String) {

    fun getLinesFromFile(): List<String> {
        val lines = mutableListOf<String>()
        val inputStream = InputStreamReader(context.assets.open(fileName ))
        val buffer = BufferedReader(inputStream)
        buffer.forEachLine { line -> lines.add(line) }
        return lines
    }

}