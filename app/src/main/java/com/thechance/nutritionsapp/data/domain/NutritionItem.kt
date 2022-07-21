package com.thechance.nutritionsapp.data.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NutritionItem(
    val id: Int,
    val name: String,
    val servingSize: String,
    val calories: Int,
    val carbs: Double,
    val proteins: Double,
    val fats: Double,
    var fiber: String,
    var iron: String,
    var vitamin_c: String,
    val cholesterol: String,

    ) : Parcelable