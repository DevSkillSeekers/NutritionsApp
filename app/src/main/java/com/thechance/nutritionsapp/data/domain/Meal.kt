package com.thechance.nutritionsapp.data.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val id: Int,
    val image: String,
    val title: String,
    val carb: String,
    val protein: String,
    val fat: String,
    val servingSize: String,
    val preparationSteps: String,
) : Parcelable
