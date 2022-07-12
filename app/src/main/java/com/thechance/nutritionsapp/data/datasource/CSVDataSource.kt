package com.thechance.nutritionsapp.data.datasource

import android.content.Context
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.FileReader

abstract class CSVDataSource<T>(val context: Context, val fileName: String = Constants.FILE_NUTRITION){
    abstract fun getAllItems():List<T>
}