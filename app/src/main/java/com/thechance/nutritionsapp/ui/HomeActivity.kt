package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.data.datasource.HealthyFoodDataSource
import com.thechance.nutritionsapp.ui.search.SearchFragment
import com.thechance.nutritionsapp.util.Constants

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        setListeners()
    }

    private fun setData() {
        binding.toolbar.visibility = View.GONE
    }

    private fun setListeners() {
        binding.bottomNav.setOnItemSelectedListener { bottomMenuItem ->
            when (bottomMenuItem.itemId) {
                R.id.home_menu -> {
                    binding.toolbar.visibility = View.GONE
                    changeFragment(HomeFragment(), Constants.REPLACE_FRAGMENT)
                    true
                }
                R.id.bmi_calculator_menu -> {
                    binding.toolbar.visibility = View.VISIBLE
                    binding.toolbar.title = resources.getString(R.string.bmi)
                    changeFragment(BMIFragment(), Constants.REPLACE_FRAGMENT)
                    true
                }
                R.id.search_menu -> {
                    binding.toolbar.visibility = View.VISIBLE
                    binding.toolbar.title = resources.getString(R.string.search)
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
        val transaction = supportFragmentManager.beginTransaction()
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

}