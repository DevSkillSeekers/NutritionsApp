package com.thechance.nutritionsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import com.thechance.nutritionsapp.datasource.CSVDataSource

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /*
    read from csv
    private fun setup() {
        val dataSource = CSVDataSource(applicationContext)
        val data = dataSource.getAllApps()
        binding.tvText.text = data.take(10).toString()
    }*/

}