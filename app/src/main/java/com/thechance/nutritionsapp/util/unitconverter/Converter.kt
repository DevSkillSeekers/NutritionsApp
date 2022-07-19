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
}