package com.thechance.nutritionsapp.data

import com.thechance.nutritionsapp.data.domain.NutritionItem

object DataManger {
    private val nutritionList = mutableListOf<NutritionItem>()

    fun addNutritionItem(nutritionItem: NutritionItem){
        nutritionList.add(nutritionItem)
    }

    fun getNutrition(size:Int): List<NutritionItem> {
        return nutritionList.take(size)
    }

    fun getSpecificNutrition(keyword:String):List<NutritionItem>{
        return nutritionList.filter { item -> item.name.contains(keyword) }
    }
}