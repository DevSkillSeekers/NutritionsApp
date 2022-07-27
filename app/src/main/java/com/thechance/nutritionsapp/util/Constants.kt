package com.thechance.nutritionsapp.util

object Constants {

    object NutritionColumnIndex {
        const val Item_ID = 0
        const val NAME = 1
        const val SERVING_SIZE = 2
        const val CALORIES = 3
        const val FAT = 67
        const val PROTEIN = 38
        const val CARBS = 58
        const val FIBER = 59
        const val IRON = 31
        const val VITAMIN_C = 24
        const val CHOLESTEROL = 6
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
    const val EXTRA_NUTRITION_DETAILS = "nutrition"

    const val EXTRA_MEAL_TYPE = "MEAL_TYPE"
    const val EXTRA_BREAKFAST = "MEAL_BREAKFAST"
    const val EXTRA_LUNCH = "MEAL_LUNCH"
    const val EXTRA_DINNER = "MEAL_DINNER"


    const val BREAKFAST = 0
    const val LUNCH = 1
    const val DINNER = 2
    const val MAX_CALORIES_PER_DAY = 2000

    object StandardDiet {
        const val MAX_CARBS_PER_DAY = 300
        const val MAX_PROTEINS_PER_DAY = 65
        const val MAX_FATS_PER_DAY = 65
    }

    object KetoDiet {
        const val MAX_CARBS_PER_DAY = 40
        const val MAX_PROTEINS_PER_DAY = 75
        const val MAX_FATS_PER_DAY = 165
    }

    object HighProteinDiet {
        const val MAX_CARBS_PER_DAY = 202
        const val MAX_PROTEINS_PER_DAY = 65
        const val MAX_FATS_PER_DAY = 173
    }

    object MediterraneanDiet {
        const val MAX_CARBS_PER_DAY = 167
        const val MAX_PROTEINS_PER_DAY = 50
        const val MAX_FATS_PER_DAY = 135
    }

    const val ACTION_OPEN = 11
    const val ACTION_DELETE = 12

    // Shared preferences
    const val LOGIN_STATUS = "LOGIN_STATUS"
    const val TABLE_NAME = "MySharedPrefs"
    const val USER_NAME = "USER_NAME"
    const val USER_WEIGHT = "Weight"
    const val USER_HEIGHT = "height"
    const val USER_AGE = "age"
}