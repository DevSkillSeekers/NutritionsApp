package com.thechance.nutritionsapp.util.unitconverter

import android.text.Editable
import com.thechance.nutritionsapp.data.domain.NutritionItem

class NutrationFacts() {

    fun calcultionOfNuTritionFacts(amountOfNutritionItem : Double, servingNumber: Double, unit: String): Double{
        var result: Double = 0.0
       when {
           unit.equals("g") ->
            result = amountOfNutritionItem * (servingNumber / 100)
           (unit.equals("kg")) ->
                 result = amountOfNutritionItem * ((servingNumber * 1000)/100)
           (unit.equals("mg")) ->
               result = amountOfNutritionItem * ((servingNumber * 0.001)/100)
           (unit.equals("lb")) ->
               result = amountOfNutritionItem * ((servingNumber * 453.592)/100)
       }
        return result
     }
}