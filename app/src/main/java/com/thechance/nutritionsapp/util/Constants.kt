package com.thechance.nutritionsapp.util

object Constants {

    object NutritionColumnIndex {
        const val Item_ID = 0
        const val NAME = 1
        const val SERVING_SIZE = 2
        const val CALORIES = 3
        const val FAT = 4
        const val PROTEIN = 39
        const val CARBS = 59
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
        const val IMAGE = 8
    }

    const val FILE_NUTRITION = "nutrition.csv"
    const val FILE_HEALTHY_FOOD = "healthyFood.csv"
    const val REPLACE_FRAGMENT = 0
    const val ADD_FRAGMENT = 1
    const val EXTRA_MEAL_DETAILS = "meal"

    const val EXTRA_Add_MEAL = "Add_item_to_meal"
    const val MEAL_ITEMS_DATA = "meal_item_data"

    const val EXTRA_MEAL_TYPE = "MEAL_TYPE"
    const val EXTRA_BREAKFAST = "MEAL_BREAKFAST"
    const val EXTRA_LUNCH = "MEAL_LUNCH"
    const val EXTRA_DINNER = "MEAL_DINNER"


    const val BREAKFAST = 0
    const val LUNCH = 1
    const val DINNER = 2
    const val MAX_CALORIES_PER_DAY = 2000

    const val ACTION_OPEN = 11
    const val ACTION_DELETE = 12

}