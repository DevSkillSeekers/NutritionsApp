package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import com.thechance.nutritionsapp.datasource.CSVDataSource
import com.thechance.nutritionsapp.utilities.Constant
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.sql.DataSource

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding).root)
        setup()
    }

    private fun setup() {
        val dataSource = CSVDataSource(applicationContext)
        val data = dataSource.getAllApps()
        binding.tvText.text = data.take(10).toString()
    }

}