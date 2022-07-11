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

    fun getAllNutrition(): List<NutritionItem> {
        val nutritionList = mutableListOf<NutritionItem>()
        fileReader.getLinesFromFile().forEach { line ->
            val nutritionItem = parseStringToNutrition(line)
            if (nutritionItem != null)
                nutritionList.add(nutritionItem)
        }
        return nutritionList.distinctBy { nutritionItem ->
            Pair(
                nutritionItem.id,
                nutritionItem.name
            )
        }
    }

    private fun parseStringToNutrition(nutritionStr: String): NutritionItem? {
        return if (nutritionStr.isNotEmpty() && nutritionStr.isNotBlank()) {
            val fields = nutritionStr.split(",")
            NutritionItem(
                fields[Constants.ColumnIndex.Item_ID].toInt(),
                fields[Constants.ColumnIndex.NAME],
                fields[Constants.ColumnIndex.SERVING_SIZE],
                fields[Constants.ColumnIndex.CALORIES].toInt(),
            )
        } else {
            null
        }
    }
}