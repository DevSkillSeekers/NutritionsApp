package com.thechance.nutritionsapp.util

object Constants {

    object NutritionColumnIndex {
        const val Item_ID = 0
        const val NAME = 1
        const val SERVING_SIZE = 2
        const val CALORIES = 3
    }

    object FoodColumnIndex {
        const val NAME = 0
        const val CALORIES = 1
        const val SERVINGS = 2
        const val CARBS = 3
        const val FAT = 4
        const val PROTEIN = 5
        const val INGREDIENTS = 6
        const val PREPARATION = 7
    }

    const val FILE_NUTRITION = "nutrition.csv"
    const val FILE_HEALTHY_FOOD = "healthyfood.csv"
    const val REPLACE_FRAGMENT = 0
    const val ADD_FRAGMENT = 1
    const val EXTRA_MEAL_DETAILS = "meal"
}