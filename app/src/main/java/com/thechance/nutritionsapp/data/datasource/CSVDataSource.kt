package com.thechance.nutritionsapp.data.datasource

import android.content.Context
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.FileReader

class CSVDataSource(
    private var context: Context,
    private var fileName: String = Constants.FILE_NAME
) {
    private val fileReader by lazy { FileReader(context, fileName) }

    fun getAllApps(): List<NutritionItem> {
        val apps = mutableListOf<NutritionItem>()
        fileReader.getListOFLinesInFile()?.let {
            it.forEach { line ->
                val app = parseStringToApp(line)
                if (app != null)
                    apps.add(app)
            }
        }
        return apps.distinctBy { app -> Pair(app.id, app.name) }
    }

    private fun parseStringToApp(appStr: String): NutritionItem? {
        return if (appStr.isNotEmpty() && appStr.isNotBlank()) {
            val appFields = appStr.split(",")
            NutritionItem(
                appFields[Constants.ColumnIndex.Item_ID].toInt(),
                appFields[Constants.ColumnIndex.NAME],
                appFields[Constants.ColumnIndex.SERVING_SIZE],
                appFields[Constants.ColumnIndex.CALORIES].toInt(),
            )
        } else {
            null
        }
    }
}