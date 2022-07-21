package com.thechance.nutritionsapp

import android.app.Application
import android.content.Context

class NutritionApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: NutritionApp? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

}