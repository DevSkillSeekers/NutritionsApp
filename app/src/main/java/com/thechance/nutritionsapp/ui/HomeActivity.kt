package com.thechance.nutritionsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.thechance.nutritionsapp.R

class HomeActivity : AppCompatActivity() {
    private val searchFragment = SearchFragment()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}