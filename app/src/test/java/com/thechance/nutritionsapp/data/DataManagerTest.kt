package com.thechance.nutritionsapp.data

import com.thechance.nutritionsapp.data.domain.NutritionItem
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DataManagerTest {
    /*lateinit var dataManager: DataManager
    @BeforeEach
    fun setUp(){
        dataManager = DataManager()
    }*/

    @Test
    fun should_NutritionListIncreasedByOneItem_When_AddItemToList(){
        //given
        val dataManager = DataManager()
        val item = NutritionItem(0,"egg","100g",225)
        //when
        dataManager.addItem(item)
        //then
        assertEquals(mutableListOf(item), dataManager.nutritionList)
    }
    @Test
    fun should_BreakfastListIncreasedByOneItem_When_AddItemToList(){
        //given
        val dataManager = DataManager()
        val item = NutritionItem(0,"egg","100g",225)
        //when
        dataManager.addBreakfastItem(item)
        //then
        assertEquals(mutableListOf(item), dataManager.breakfastItems)
    }
    @Test
    fun should_LunchListIncreasedByOneItem_When_AddItemToList(){
        //given
        val dataManager = DataManager()
        val item = NutritionItem(0,"egg","100g",225)
        //when
        dataManager.addLunchItem(item)
        //then
        assertEquals(mutableListOf(item), dataManager.lunchItems)
    }
    @Test
    fun should_DinnerListIncreasedByOneItem_When_AddItemToList(){
        //given
        val dataManager = DataManager()
        val item = NutritionItem(0,"egg","100g",225)
        //when
        dataManager.addDinnerItem(item)
        //then
        assertEquals(mutableListOf(item), dataManager.dinnerItems)
    }
    @Test
    fun should_BreakfastListDecreasedByOneItem_When_RemoveItemFromList(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        //when
        dataManager.addBreakfastItem(egg)
        dataManager.addBreakfastItem(orange)
        dataManager.removeBreakfastItem(egg)
        //then
        assertEquals(mutableListOf(orange), dataManager.breakfastItems)
    }
    @Test
    fun should_LunchListDecreasedByOneItem_When_RemoveItemFromList(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        //when
        dataManager.addLunchItem(egg)
        dataManager.addLunchItem(orange)
        dataManager.removeLunchItem(orange)
        //then
        assertEquals(mutableListOf(egg), dataManager.lunchItems)
    }
    @Test
    fun should_DinnerListDecreasedByOneItem_When_RemoveItemFromList(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        //when
        dataManager.addDinnerItem(egg)
        dataManager.addDinnerItem(orange)
        dataManager.removeDinnerItem(egg)
        //then
        assertEquals(mutableListOf(orange), dataManager.dinnerItems)
    }
    @Test
    fun should_ReturnEmptyNutritionList_When_ListIsEmpty(){
        //given
        val dataManager = DataManager()
        //when
        val itemsList = dataManager.getNutrition(5)
        //then
        assertEquals(mutableListOf<NutritionItem>(),itemsList)
    }
    @Test
    fun should_ReturnSpecifiedNutritionList_When_OriginalListIsBiggerthanSpecifiedSize(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        val avocado = NutritionItem(2,"avocado","100g",230)
        //when
        dataManager.addItem(egg)
        dataManager.addItem(orange)
        dataManager.addItem(avocado)
        val itemsList = dataManager.getNutrition(2)
        //then
        assertEquals(mutableListOf<NutritionItem>(egg,orange),itemsList)
    }
    @Test
    fun should_ReturnAllNutritionList_When_OriginalListIsSmallerThanSpecifiedSize(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        val avocado = NutritionItem(2,"avocado","100g",230)
        //when
        dataManager.addItem(egg)
        dataManager.addItem(orange)
        dataManager.addItem(avocado)
        val itemsList = dataManager.getNutrition(5)
        //then
        assertEquals(mutableListOf<NutritionItem>(egg,orange,avocado),itemsList)
    }
    @Test
    fun should_ReturnFilteredList_WhenNutritionListHasItemsHaveSpecifiedString(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        val avocado = NutritionItem(2,"avocado","100g",230)
        //when
        dataManager.addItem(egg)
        dataManager.addItem(orange)
        dataManager.addItem(avocado)
        val itemsList = dataManager.getSpecificNutrition("e")
        //then
        assertEquals(mutableListOf(egg,orange),itemsList)
    }
    @Test
    fun should_ReturnCorrectCalories_When_BreakfastListIsNotEmpty(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        //when
        dataManager.addBreakfastItem(egg)
        dataManager.addBreakfastItem(orange)
        val calories = dataManager.getBreakfastCalories()
        //then
        assertEquals(375,calories)
    }
    @Test
    fun should_ReturnNull_When_BreakfastListIsEmpty(){
        //given
        val dataManager = DataManager()
        //when
        val calories = dataManager.getBreakfastCalories()
        //then
        assertEquals(null,calories)
    }
    @Test
    fun should_ReturnCorrectCalories_When_LunchListIsNotEmpty(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        //when
        dataManager.addLunchItem(egg)
        dataManager.addLunchItem(orange)
        val calories = dataManager.getLunchCalories()
        //then
        assertEquals(375,calories)
    }
    @Test
    fun should_ReturnNull_When_LunchListIsEmpty(){
        //given
        val dataManager = DataManager()
        //when
        val calories = dataManager.getLunchCalories()
        //then
        assertEquals(null,calories)
    }
    @Test
    fun should_ReturnCorrectCalories_When_DinnerListIsNotEmpty(){
        //given
        val dataManager = DataManager()
        val egg = NutritionItem(0,"egg","100g",225)
        val orange = NutritionItem(1,"orange","100g",150)
        //when
        dataManager.addDinnerItem(egg)
        dataManager.addDinnerItem(orange)
        val calories = dataManager.getDinnerCalories()
        //then
        assertEquals(375,calories)
    }
    @Test
    fun should_ReturnNull_When_DinnerListIsEmpty(){
        //given
        val dataManager = DataManager()
        //when
        val calories = dataManager.getDinnerCalories()
        //then
        assertEquals(null,calories)
    }
}