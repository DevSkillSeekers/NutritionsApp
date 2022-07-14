package com.thechance.nutritionsapp.util.unitconverter
import com.thechance.nutritionsapp.util.unitconverter.Converter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ConverterTest {
    private var converter = Converter()
    @Test
    fun should_ReturnNull_When_AmountIsInvalid() {
        //Given : amount, convertTo, convertFrom, converterType
        val amount = -1.0
        val convertTo = "Gram"
        val convertFrom = "Kilogram"
        val converterType = "Weight"

        //When amount is minus
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertNull(result)
    }

    @Test
    fun should_ReturnZero_When_AmountIsZero(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 0.0
        val convertTo = "Gram"
        val convertFrom = "Kilogram"
        val converterType = "Weight"

        //When amount is zero
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(0.0,result)
    }
    @Test
    fun should_ReturnValidResult_When_AmountIsValid(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 10.0
        val convertTo = "Gram"
        val convertFrom = "Kilogram"
        val converterType = "Weight"

        //When amount is valid
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(10000.0,result)
    }


    @Test
    fun should_ReturnExpectValue_When_ConvertFromKgToGram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 10.0
        val convertTo = "Gram"
        val convertFrom = "Kilogram"
        val converterType = "Weight"

        //When
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(10000.0,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromKgToMilligram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 1.0
        val convertTo = "Milligram"
        val convertFrom = "Kilogram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(1000000.0,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromKgToPound(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 8.0
        val convertTo = "Pound"
        val convertFrom = "Kilogram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(17.63696,result)
    }
    @Test
    fun should_ReturnExpectValue_When_ConvertFromGramToKg(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 1000.0
        val convertTo = "Kilogram"
        val convertFrom = "Gram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(1.0,result)
    }
    @Test
    fun should_ReturnExpectValue_When_ConvertFromGramToPound(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 8.0
        val convertTo = "Pound"
        val convertFrom = "Gram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(0.01763696,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromGramToMilligram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 1000.0
        val convertTo = "Milligram"
        val convertFrom = "Gram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(1000000.0,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromPoundToKilogram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 55.0
        val convertTo = "Kilogram"
        val convertFrom = "Pound"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(24.947610018960184,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromPoundToGram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 100.0
        val convertTo = "Gram"
        val convertFrom = "Pound"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(45359.29094356397,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromPoundToMilliGram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 5.0
        val convertTo = "Milligram"
        val convertFrom = "Pound"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(2267964.5471781986,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromMilligramToKilogram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 10000.0
        val convertTo = "Kilogram"
        val convertFrom = "Milligram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(0.01,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromMilligramToGram(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 10000.0
        val convertTo = "Gram"
        val convertFrom = "Milligram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(10.0,result)
    }

    @Test
    fun should_ReturnExpectValue_When_ConvertFromMilligramToPound(){
        //Given : amount, convertTo, convertFrom, converterType
        val amount = 57866.0
        val convertTo = "Pound"
        val convertFrom = "Milligram"
        val converterType = "Weight"

        //When 
        val result = converter.convertFromTypeToOther(converterType,convertFrom,convertTo,amount)

        //then
        assertEquals(0.12757254092,result)
    }
}