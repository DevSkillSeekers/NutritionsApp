package com.thechance.nutritionsapp.data

import android.content.Context
import com.thechance.nutritionsapp.data.datasource.HealthyFoodDataSource
import com.thechance.nutritionsapp.data.datasource.NutritionDataSource
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.util.Constants

class DataManager(context: Context) {
    private val nutritionList = mutableListOf<NutritionItem>()
    private val breakfastItems = mutableListOf<NutritionItem>()
    private val lunchItems = mutableListOf<NutritionItem>()
    private val dinnerItems = mutableListOf<NutritionItem>()

    private val healthyFoodList = mutableListOf<HealthyFood>()

    init {
        val dataSource = HealthyFoodDataSource(context)
        dataSource.getAllItems().forEach { food ->
            healthyFoodList.add(food)
        }
        NutritionDataSource(context).getAllItems().forEach { nutritionItem ->
            nutritionList.add(nutritionItem)
        }
    }

    fun getHealthyMeal(mealType: Int): List<HealthyFood> {
        return when (mealType) {
            Constants.BREAKFAST -> {
                healthyFoodList.subList(0, 3)
            }
            Constants.LUNCH -> {
                healthyFoodList.subList(3, 6)
            }
            else -> {
                healthyFoodList.subList(6, 9)
            }
        }
    }

    fun getMeals(mealType: Int): List<NutritionItem> {
        return when (mealType) {
            Constants.BREAKFAST -> {
                breakfastItems
            }
            Constants.LUNCH -> {
                lunchItems
            }
            else -> {
                dinnerItems
            }
        }
    }

    fun getMealCalories(mealType: Int): Int {
        return when (mealType) {
            Constants.BREAKFAST -> {
                if (breakfastItems.isEmpty()) 0
                else breakfastItems.sumOf { it.calories }
            }
            Constants.LUNCH -> {
                if (lunchItems.isEmpty()) 0
                else lunchItems.sumOf { it.calories }
            }
            Constants.DINNER -> {
                if (dinnerItems.isEmpty())
                    0
                else dinnerItems.sumOf { it.calories }
            }
            else -> {
                0
            }
        }

    }

    fun getMealCarbs(mealType: Int): Double {
        return when (mealType) {
            Constants.BREAKFAST -> {
                if (breakfastItems.isEmpty()) 0.0
                else breakfastItems.sumOf { it.carbs }
            }
            Constants.LUNCH -> {
                if (lunchItems.isEmpty()) 0.0
                else lunchItems.sumOf { it.carbs }
            }
            Constants.DINNER -> {
                if (dinnerItems.isEmpty()) 0.0
                else dinnerItems.sumOf { it.carbs }
            }
            else -> {
                0.0
            }
        }

    }

    fun getMealProteins(mealType: Int): Double {
        return when (mealType) {
            Constants.BREAKFAST -> {
                if (breakfastItems.isEmpty()) 0.0
                else breakfastItems.sumOf { it.proteins }
            }
            Constants.LUNCH -> {
                if (lunchItems.isEmpty()) 0.0
                else lunchItems.sumOf { it.proteins }
            }
            Constants.DINNER -> {
                if (dinnerItems.isEmpty()) 0.0
                else dinnerItems.sumOf { it.proteins }
            }
            else -> {
                0.0
            }
        }

    }

    fun getMealFats(mealType: Int): Double {
        return when (mealType) {
            Constants.BREAKFAST -> {
                if (breakfastItems.isEmpty()) 0.0
                else breakfastItems.sumOf { it.fats }
            }
            Constants.LUNCH -> {
                if (lunchItems.isEmpty()) 0.0
                else lunchItems.sumOf { it.fats }
            }
            Constants.DINNER -> {
                if (dinnerItems.isEmpty()) 0.0
                else dinnerItems.sumOf { it.fats }
            }
            else -> {
                0.0
            }
        }

    }

    fun getRemainderCaloriesPerDay(): Int {
        var remainder = Constants.MAX_CALORIES_PER_DAY
        remainder -= getMealCalories(Constants.BREAKFAST)
        remainder -= getMealCalories(Constants.LUNCH)
        remainder -= getMealCalories(Constants.DINNER)
        return remainder
    }

    fun getProgressCalories(): Int =
        Constants.MAX_CALORIES_PER_DAY.div(getRemainderCaloriesPerDay()).times(100)

    fun getProgressCarbs(): Double =
        getMealCarbs(Constants.BREAKFAST) + getMealCarbs(Constants.LUNCH) + getMealCarbs(Constants.DINNER)

    fun getProgressProtein(): Double =
        getMealProteins(Constants.BREAKFAST) + getMealProteins(Constants.LUNCH) + getMealProteins(
            Constants.DINNER
        )

    fun getProgressFat(): Double =
        getMealFats(Constants.BREAKFAST) + getMealFats(Constants.LUNCH) + getMealFats(Constants.DINNER)


    fun getNutrition(size: Int): List<NutritionItem> {
        return nutritionList.take(size)
    }

    fun addBreakfastItem(item: NutritionItem) {
        breakfastItems.add(item)
    }

    fun addLunchItem(item: NutritionItem) {
        lunchItems.add(item)
    }

    fun addDinnerItem(item: NutritionItem) {
        dinnerItems.add(item)
    }

    fun removeBreakfastItem(item: NutritionItem) {
        breakfastItems.remove(item)
    }

    fun removeLunchItem(item: NutritionItem) {
        lunchItems.remove(item)
    }

    fun removeDinnerItem(item: NutritionItem) {
        dinnerItems.remove(item)
    }

    fun getSpecificNutrition(keyword: String): List<NutritionItem> {
        return nutritionList.filter { item -> item.name.contains(keyword) }
    }

    fun addBreakfast(breakfast: ArrayList<NutritionItem>) {
        breakfastItems.addAll(breakfast)
    }

    fun addLunch(lunch: ArrayList<NutritionItem>) {
        lunchItems.addAll(lunch)
    }

    fun addDinner(dinner: ArrayList<NutritionItem>) {
        dinnerItems.addAll(dinner)
    }
}