package com.thechance.nutritionsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import com.thechance.nutritionsapp.ui.search.SearchFragment
import com.thechance.nutritionsapp.util.Constants


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.bottomNav.setOnItemSelectedListener { bottomMenuItem ->
            when (bottomMenuItem.itemId) {
                com.thechance.nutritionsapp.R.id.home_menu -> {
                    changeFragment(HomeFragment(), Constants.REPLACE_FRAGMENT)
                    true
                }
                com.thechance.nutritionsapp.R.id.bmi_calculator_menu -> {
                    changeFragment(BMIFragment(), Constants.REPLACE_FRAGMENT)
                    true
                }
                com.thechance.nutritionsapp.R.id.search_menu -> {
                    changeFragment(SearchFragment(), Constants.REPLACE_FRAGMENT)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun changeFragment(fragment: Fragment, type: Int) {
        val transaction = supportFragmentManager.beginTransaction().addToBackStack(null)
        when (type) {
            Constants.ADD_FRAGMENT -> {
                transaction.add(R.id.nav_host_fragment, fragment)
            }
            Constants.REPLACE_FRAGMENT -> {
                transaction.replace(R.id.nav_host_fragment, fragment)
            }
        }
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.bottomNav.selectedItemId = R.id.home_menu

    }
}