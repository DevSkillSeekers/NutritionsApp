package com.thechance.nutritionsapp.data

object DataManeger {
    private val totalNutritionItems = mutableListOf<NutritionItem>()
    private val breakfastItems = mutableListOf<NutritionItem>()
    private val lunchItems = mutableListOf<NutritionItem>()
    private val dinnerItems = mutableListOf<NutritionItem>()
    /*private var itemIndex = 0
    private var breakfastItemIndex = 0
    private var lunchItemIndex = 0
    private var dinnerItemIndex = 0*/

    fun addItem(item: NutritionItem){
        totalNutritionItems.add(item)
    }
    fun addBreakfastItem(item: NutritionItem){
        breakfastItems.add(item)
    }
    fun addLunchItem(item: NutritionItem){
        lunchItems.add(item)
    }
    fun addDinnerItem(item: NutritionItem){
        dinnerItems.add(item)
    }

    fun removeBreakfastItem(item: NutritionItem){
        breakfastItems.remove(item)
    }
    fun removeLunchItem(item: NutritionItem){
        lunchItems.remove(item)
    }
    fun removeDinnerItem(item: NutritionItem){
        dinnerItems.remove(item)
    }

    /*fun getCurrentItem(): NutritionItem = totalNutritionItems[itemIndex]
    fun getCurrentBreakfastItem(): NutritionItem = breakfastItems[breakfastItemIndex]
    fun getCurrentLunchItem(): NutritionItem = lunchItems[lunchItemIndex]
    fun getCurrentDinnerItem(): NutritionItem = dinnerItems[dinnerItemIndex]*/

    /*fun getNextItem(): NutritionItem?{
        itemIndex++
        if(itemIndex == totalNutritionItems.size - 1) return null
        return totalNutritionItems[itemIndex]
    }
    fun getNextbreakfastItem(): NutritionItem?{
        breakfastItemIndex++
        if(breakfastItemIndex == breakfastItems.size - 1) return null
        return breakfastItems[breakfastItemIndex]
    }
    fun getNextLunchItem(): NutritionItem?{
        lunchItemIndex++
        if(lunchItemIndex == lunchItems.size - 1) return null
        return lunchItems[lunchItemIndex]
    }
    fun getNextDinnerItem(): NutritionItem?{
        dinnerItemIndex++
        if(dinnerItemIndex == dinnerItems.size - 1) return null
        return dinnerItems[dinnerItemIndex]
    }*/

    fun getBreakfastCalories(): Int?{
        if(breakfastItems.isEmpty()) return null
        return breakfastItems.sumOf { it.calories }
    }
    fun getLunchCalories(): Int?{
        if(lunchItems.isEmpty()) return null
        return lunchItems.sumOf { it.calories }
    }
    fun getDinnerCalories(): Int?{
        if(dinnerItems.isEmpty()) return null
        return dinnerItems.sumOf { it.calories }
    }

    fun getAllItems(): MutableList<NutritionItem>{
        return totalNutritionItems
    }
    fun getBreakfastItems(): MutableList<NutritionItem>{
        return breakfastItems
    }
    fun getLunchItems(): MutableList<NutritionItem>{
        return lunchItems
    }
}