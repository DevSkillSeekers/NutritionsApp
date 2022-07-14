package com.thechance.nutritionsapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentItemDetailsBinding
import com.thechance.nutritionsapp.util.Constants
import kotlin.math.ceil

class ItemDetailsFragment : BaseFragment<FragmentItemDetailsBinding>() {
    private lateinit var mNutritionDetails: NutritionItem

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentItemDetailsBinding =
        FragmentItemDetailsBinding::inflate

    override fun setup() {

        mNutritionDetails = arguments?.getParcelable(Constants.EXTRA_NUTRITION_DETAILS)!!

        val items = listOf("kg","g","mg","lb")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,items)
        binding.autoCompleteTextView.setAdapter(adapter)

        setData()
    }

    private fun setData() {
//        binding.progressBar.progress = ceil(mNutritionDetails.carbs).toInt()
//        binding.progressBar2.progress = mNutritionDetails.proteins.toInt()
//        binding.fatProgressBar.progress = mNutritionDetails.fats.toInt()
//        binding.progressBar3.progress = mNutritionDetails.calories
//
//        binding.textView5.text = resources.getString(R.string.carb_gram, ceil(mNutritionDetails.carbs).toString())
    }
}