package com.thechance.nutritionsapp.util

import kotlinx.coroutines.handleCoroutineException
import kotlin.math.abs

class BMI(private val Weight: Double?, private val Height: Double?) {

    fun calculation0fBMI(): Double {
        return if (Weight?.equals(abs(Weight)) == true && Height?.equals(abs(Height)) == true && Weight != 0.0 && Height != 0.0) {
            val heightM = Height.div(100)
            val result = Weight.div((heightM.times(heightM)))
            String.format("%.2f", result).toDouble()
        } else {
            -1.0
        }
    }

    fun diagnostic(bmiRAW: Double): String {
        var result = ""
        val strBMI = String.format("%.02f", bmiRAW)

        if (bmiRAW != -1.0) {
            when {
                bmiRAW <= 16.0 -> {
                    result += "Underweight Class II"
                }
                bmiRAW in 16.0..16.99 -> {
                    result += "Underweight class I"
                }
                bmiRAW in 17.0..18.49 -> {
                    result += "Low weight"
                }
                bmiRAW in 18.50..24.99 -> {
                    result += "Normal "
                }
                bmiRAW in 25.0..29.99 -> {
                    result += "Overweight"
                }
                bmiRAW in 30.0..34.99 -> {
                    result += "Obese Class I"
                }
                bmiRAW in 35.0..39.99 -> {
                    result += "Obese Class II"
                }
                bmiRAW >= 40 -> {
                    result += "Obese Class III"
                }
            }
        }
       // result += "    BMI: ${strBMI}kg/m²"
        return result

    }
}