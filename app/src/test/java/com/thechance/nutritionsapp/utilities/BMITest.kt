package com.thechance.nutritionsapp.utilities
import org.junit.Assert.assertEquals
import org.junit.Test


internal class BMITest {

    private lateinit var obj:BMI

    @Test
    fun should_Return_CorrectBMI_When_AttributeHasCorrectValue() {
        obj = BMI(90.0,1.7)
        val result = obj.calculation0fBMI()
        assertEquals(31.14,result)
    }
    @Test
    fun should_Return_MinusOne_When_AttributeHasZeroValue() {
        obj = BMI(0.0,0.0)
        val result = obj.calculation0fBMI()
        assertEquals(-1.0,result)
    }
    @Test
    fun should_Return_MinusOne_When_AttributeHasNullValue() {
        obj = BMI(null,null)
        val result = obj.calculation0fBMI()
        assertEquals(-1.0,result)
    }
    @Test
    fun should_Return_MinusOne_When_AttributeHasMinusValue() {
        obj = BMI(-90.0,-1.7)
        val result = obj.calculation0fBMI()
        assertEquals(-1.0,result)
    }


}