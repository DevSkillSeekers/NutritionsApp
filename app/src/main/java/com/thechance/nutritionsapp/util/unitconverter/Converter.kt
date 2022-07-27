package com.thechance.nutritionsapp.util.unitconverter

class Converter {
    fun kiloToGram(kilo : Double) : Double {
        return kilo * 1000
    }

    fun kiloToPound(kilo: Double) : Double {
        return kilo * 2.20462
    }

    fun gramToKilo(gram : Double) : Double {
        return gram / 1000
    }

    fun gramToPound(gram : Double) : Double {
        return gramToKilo(gram) * 2.20462
    }

    fun poundToKilo(pound : Double) : Double {
        return pound / 2.20462
    }
    fun poundToGram(pound: Double) : Double {
        return pound * 453.592
    }
    fun feetToCm(feet : Double) : Double {
        return feet * 30.48
    }
    fun miligramToGram(miligram: Double) : Double{
        return miligram * 0.001
    }
    fun progressLenght(value: Double, unit: String): Int{

        var result : Double = 0.0
        when {
            unit.equals("g") ->
                result = value
            (unit.equals("kg")) ->
                result = kiloToGram(value)
            (unit.equals("mg")) ->
                result = 1.0
            (unit.equals("lb")) ->
                result = poundToGram(value)
        }
        return result.toInt()
    }
}