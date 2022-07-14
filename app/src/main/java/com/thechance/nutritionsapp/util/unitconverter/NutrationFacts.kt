package com.thechance.nutritionsapp.util.unitconverter

import com.thechance.nutritionsapp.data.domain.NutritionItem

class NutrationFacts(private val amountOfNutritionItem : Double, private val servingNumber: Double) {

    fun calcultionOfNuTritionFacts(): Double{
        return amountOfNutritionItem * (servingNumber/100)
    }
}