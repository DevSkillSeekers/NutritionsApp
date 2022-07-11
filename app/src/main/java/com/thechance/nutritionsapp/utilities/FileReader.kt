package com.thechance.nutritionsapp.utilities

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

class FileReader(private var context: Context, private var fileName: String) {

    fun getListOFLinesInFile(): List<String>? {

        val lines = mutableListOf<String>()
        val inputStream = InputStreamReader(context.assets.open(fileName))
        val buffer = BufferedReader(inputStream)

        buffer.apply {
            buffer.forEachLine { line -> lines.add(line) }
        }
        return lines
    }

}