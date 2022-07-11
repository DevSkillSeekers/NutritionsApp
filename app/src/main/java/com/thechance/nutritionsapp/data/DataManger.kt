package com.thechance.nutritionsapp.data

import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem

object DataManger {
    private val nutritionList = mutableListOf<NutritionItem>()
    private val healthyFood = mutableListOf<HealthyFood>()

    fun addNutritionItem(nutritionItem: NutritionItem){
        nutritionList.add(nutritionItem)
    }

    fun addHealthyFood(food: HealthyFood){
        healthyFood.add(food)
    }


    fun getNutrition(size:Int): List<NutritionItem> {
        return nutritionList.take(size)
    }

    fun getSpecificNutrition(keyword:String):List<NutritionItem>{
        return nutritionList.filter { item -> item.name.contains(keyword) }
    }

    fun getBreakfast():List<HealthyFood>{
        return healthyFood
    }

}