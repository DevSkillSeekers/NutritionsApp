package com.thechance.nutritionsapp.util.unitconverter

class Converter {
    private val weight = mapOf(
        "Kilogram" to 0.001,
        "Gram" to 1.0,
        "Milligram" to 1000.0,
        "Pound" to 0.00220462,
        "cm" to 1.div(30.48),
        "feet" to 30.48
    )

    fun convertFromTypeToOther(
        converterType: String,
        convertFrom: String,
        convertTo: String,
        amount: Double
    ): Double? {
        return when {
            amount < 0 -> {
                null
            }
            else -> when (converterType) {
                //Because maybe we need add other converters
                ConverterUtil.MainConverter.weight -> amount * weight[convertTo]!! / weight[convertFrom]!!
                else -> 0.0
            }
        }
    }
}