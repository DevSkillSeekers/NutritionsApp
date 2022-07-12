package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.DataManger
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding
import com.thechance.nutritionsapp.util.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
//        binding.ivText.text = DataManger.getBreakfast().toString()
        binding.button.setOnClickListener {
            changeFragment(DetailMealFragment())
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val healthMeal = DataManger.getBreakfast().first()
        val data = Bundle()
        data.putParcelable(Constants.EXTRA_MEAL_DETAILS, healthMeal)
        fragment.arguments = data
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.nav_host_fragment, fragment).addToBackStack(null)
        transaction.commit()
    }
}