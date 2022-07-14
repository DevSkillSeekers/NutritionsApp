package com.thechance.nutritionsapp.data.datasource

import android.content.Context
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.FileReader

class HealthyFoodDataSource(context: Context, fileName: String = Constants.FILE_HEALTHY_FOOD) :
    CSVDataSource<HealthyFood>(context, fileName) {

    private val fileReader by lazy { FileReader(context, fileName) }

    override fun getAllItems(): List<HealthyFood> {
        val healthyFoodList = mutableListOf<HealthyFood>()
        fileReader.getLinesFromFile().forEach { line ->
            val item = parseStringToHealthyFood(line)
            if (item != null)
                healthyFoodList.add(item)
        }
        return healthyFoodList
    }

    private fun parseStringToHealthyFood(food: String): HealthyFood? {
        return if (food.isNotEmpty() && food.isNotBlank()) {
            val fields = food.split(",")
            HealthyFood(
                fields[Constants.FoodColumnIndex.NAME],
                fields[Constants.FoodColumnIndex.CALORIES].toInt(),
                fields[Constants.FoodColumnIndex.SERVINGS].toInt(),
                fields[Constants.FoodColumnIndex.CARBS].removeSuffix("g"),
                fields[Constants.FoodColumnIndex.FAT].removeSuffix("g"),
                fields[Constants.FoodColumnIndex.PROTEIN].removeSuffix("g"),
                fields[Constants.FoodColumnIndex.INGREDIENTS].split("-"),
                fields[Constants.FoodColumnIndex.PREPARATION].split("-"),
                fields[Constants.FoodColumnIndex.IMAGE]
            )
        } else {
            null
        }
    }
}