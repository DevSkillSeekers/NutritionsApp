package com.thechance.nutritionsapp.data.domain

data class HealthyFood(
    val name: String,
    val calorie:Int,
    val servings: Int,
    val carbs: String,
    val fat: String,
    val protein: String,
    val ingredients: List<String>,
    val preparation: List<String>
)