package com.thechance.nutritionsapp.data

import com.thechance.nutritionsapp.data.domain.NutritionItem

class DataManager {
    var nutritionList = mutableListOf<NutritionItem>()
        private set
    var breakfastItems = mutableListOf<NutritionItem>()
        private set
    var lunchItems = mutableListOf<NutritionItem>()
        private set
    var dinnerItems = mutableListOf<NutritionItem>()
        private set
    var meals = mutableListOf<String>()
        private set

    fun getNutrition(size: Int): List<NutritionItem> {
        return nutritionList.take(size)
    }

    fun addItem(item: NutritionItem) {
        nutritionList.add(item)
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

    fun getBreakfastCalories(): Int? {
        if (breakfastItems.isEmpty()) return null
        return breakfastItems.sumOf { it.calories }
    }

    fun getLunchCalories(): Int? {
        if (lunchItems.isEmpty()) return null
        return lunchItems.sumOf { it.calories }
    }

    fun getDinnerCalories(): Int? {
        if (dinnerItems.isEmpty()) return null
        return dinnerItems.sumOf { it.calories }
    }

    fun getAllItems(): MutableList<NutritionItem>? {
        if(nutritionList.isEmpty()) return null
        return nutritionList
    }
}