package com.thechance.nutritionsapp.data.datasource

import android.content.Context
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.FileReader

class NutritionDataSource(fileName: String = Constants.FILE_NUTRITION) :
    CSVDataSource<NutritionItem>(fileName) {

    private val fileReader by lazy { FileReader(fileName) }

    override fun getAllItems(): List<NutritionItem> {
        val nutritionList = mutableListOf<NutritionItem>()
        fileReader.getLinesFromFile().forEach { line ->
            val nutritionItem = parseStringToNutrition(line)
            if (nutritionItem != null){
                nutritionList.add(nutritionItem)
            }
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
                fields[Constants.NutritionColumnIndex.Item_ID].toInt(),
                fields[Constants.NutritionColumnIndex.NAME],
                fields[Constants.NutritionColumnIndex.SERVING_SIZE],
                fields[Constants.NutritionColumnIndex.CALORIES].toInt(),
                fields[Constants.NutritionColumnIndex.CARBS].removeSuffix("g").toDouble(),
                fields[Constants.NutritionColumnIndex.PROTEIN].removeSuffix(" g").toDouble(),
                fields[Constants.NutritionColumnIndex.FAT].removeSuffix(" g").toDouble(),
                fields[Constants.NutritionColumnIndex.FIBER],
                fields[Constants.NutritionColumnIndex.IRON],
                fields[Constants.NutritionColumnIndex.VITAMIN_C],
                fields[Constants.NutritionColumnIndex.CHOLESTEROL],













                )
        } else {
            null
        }
    }

}