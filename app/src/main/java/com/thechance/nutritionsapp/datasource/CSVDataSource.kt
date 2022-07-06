package com.thechance.nutritionsapp.datasource

import android.content.Context
import com.thechance.nutritionsapp.data.NutritionItem
import com.thechance.nutritionsapp.utilities.Constant
import com.thechance.nutritionsapp.utilities.FileReader

class CSVDataSource(
    private var context: Context,
    private var fileName: String = Constant.FILE_NAME
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
                appFields[Constant.ColumnIndex.Item_ID].toInt(),
                appFields[Constant.ColumnIndex.NAME],
                appFields[Constant.ColumnIndex.SERVING_SIZE],
                appFields[Constant.ColumnIndex.CALORIES].toInt(),
            )
        } else {
            null
        }
    }
}