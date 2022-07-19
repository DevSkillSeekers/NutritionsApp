package com.thechance.nutritionsapp.util.unitconverter
import com.thechance.nutritionsapp.util.unitconverter.Converter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance

@Suppress("DEPRECATION")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ConverterTest {
    private var converter = Converter()
    @Test
    fun should_ReturnZero_WhenKiloIsZeroInKiloToGram() {
        //Given Kilogram
        val kilo = 0.0
        //when Kilo to gram and kilo is zero
        val result = converter.kiloToGram(kilo)
        //then result is zero
        assertEquals(0.0, result)
    }

    @Test
    fun should_Return1000Gram_WhenKiloIsOneInKiloToGram() {
        //Given Kilogram
        val kilo = 1.0
        //when Kilo to gram and kilo is zero
        val result = converter.kiloToGram(kilo)
        //then result is zero
        assertEquals(1000.0, result)
    }

    @Test
    fun should_ReturnZero_WhenKiloIsZeroInConvertKiloToPounds() {
        //Given Kilogram
        val kilo = 0.0
        //when Kilo to pound and kilo is zero
        val result = converter.kiloToPound(kilo)
        //then result is zero
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnValueCorrectInPounds_WhenKiloIsOne() {
        //Given Kilogram
        val kilo = 1.0
        //when Kilo to pound
        val result = converter.kiloToPound(kilo)
        //then result is 2.20462
        assertEquals(2.20462, result)
    }

    @Test
    fun should_ReturnZero_WhenGramIsZeroInGramToKilo() {
        //Given gram
        val gram = 0.0
        //when gram to kilo and gram is zero
        val result = converter.gramToKilo(gram)
        //then result is zero
        assertEquals(0.0, result)
    }

    @Test
    fun should_Return1Kg_WhenGramIs1000InGramToKilo() {
        //Given gram
        val gram = 1000.0
        //when gram to kilo and gram is 1000
        val result = converter.gramToKilo(gram)
        //then result is zero
        assertEquals(1.0, result)
    }

    @Test
    fun should_ReturnZero_WhenGramIsZeroInGramToPound() {
        //Given gram
        val gram = 0.0
        //when gram to Pound and gram is zero
        val result = converter.gramToPound(gram)
        //then result is zero
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnValueInPounds_WhenGramIsValidInGramToPound() {
        //Given gram
        val gram = 10.0
        //when gram to pound
        val result = converter.gramToPound(gram)
        //then result is 0.0220462
        assertEquals(0.0220462, result)
    }


    @Test
    fun should_ReturnZero_WhenPoundIsZeroInPoundsToGram() {
        //Given gram
        val pound = 0.0
        //when pound to gram and pound is zero
        val result = converter.poundToGram(pound)
        //then result is zero
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnValueInPounds_WhenPoundIsValidInPoundToGram() {
        //Given pound
        val pound = 10.0
        //when pound to gram
        val result = converter.poundToGram(pound)
        //then result is 4535.92
        assertEquals(4535.92, result)
    }

    @Test
    fun should_ReturnZero_WhenPoundIsZeroInPoundsToKilo() {
        //Given gram
        val pound = 0.0
        //when pound to Kilo and pound is zero
        val result = converter.poundToKilo(pound)
        //then result is zero
        assertEquals(0.0, result)
    }

    @Test
    fun should_ReturnValueInPounds_WhenPoundIsValidInPoundToKilo() {
        //Given pound
        val pound = 1.0
        //when pound to Kilo
        val result = converter.poundToKilo(pound)
        //then result is 0.45359290943563974
        assertEquals(0.45359290943563974, result)
    }
}