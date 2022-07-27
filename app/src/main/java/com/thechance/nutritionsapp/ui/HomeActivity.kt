package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import com.thechance.nutritionsapp.ui.home.HomeFragment


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeFragment(LoginFragment())
        setListeners()
    }

    private fun setListeners() {
        binding.bottomNav.setOnItemSelectedListener { bottomMenuItem ->
            when (bottomMenuItem.itemId) {
                com.thechance.nutritionsapp.R.id.home_menu -> {
                    changeFragment(HomeFragment())
                    true
                }
                com.thechance.nutritionsapp.R.id.bmi_calculator_menu -> {
                    changeFragment(BMIFragment())
                    true
                }
                com.thechance.nutritionsapp.R.id.diet_menu -> {
                    changeFragment(DietTypeFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction().addToBackStack(null)
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }
}