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
import com.thechance.nutritionsapp.util.unitconverter.Converter
import com.thechance.nutritionsapp.util.unitconverter.NutrationFacts
import kotlin.math.ceil

class ItemDetailsFragment : BaseFragment<FragmentItemDetailsBinding>() {
    private lateinit var mNutritionDetails: NutritionItem
      var converter = Converter()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentItemDetailsBinding =
        FragmentItemDetailsBinding::inflate

    override fun setup() {

        mNutritionDetails = arguments?.getParcelable(Constants.EXTRA_NUTRITION_DETAILS)!!
        var reslt = converter.convertFromTypeToOther("weight","kg","g",1000.0)

        val items = listOf("kg","g","mg","lb")
        val adapter = ArrayAdapter(requireActivity(), R.layout.dropdown_item,items)
        binding.autoCompleteTextView.setAdapter(adapter)

        setData()
    }

    private fun setData() {

        binding.progressBar.progress = (mNutritionDetails.carbs).toInt()
        binding.progressBar2.progress = (mNutritionDetails.proteins).toInt()
        binding.fatProgressBar.progress = (mNutritionDetails.fats).toInt()
        binding.progressBar3.progress = mNutritionDetails.calories

        binding.textView9.text = mNutritionDetails.calories.toString().replace("gram","")
       binding.textView5.text = resources.getString(R.string.carb_gram, (mNutritionDetails.carbs).toString())
        binding.textView7.text = resources.getString(R.string.carb_gram, (mNutritionDetails.proteins).toString())
        binding.textView.text = resources.getString(R.string.carb_gram, (mNutritionDetails.fats).toString())
        binding.fiberamount.text=  mNutritionDetails.fiber.replace("mg","")
        binding.ironAmount.text=  mNutritionDetails.iron.replace("mg","")
        binding.vitaminCAmount.text =  mNutritionDetails.vitamin_c.replace("g","")
        binding.cholesterol.text =  mNutritionDetails.cholesterol.replace("g","")








    }
}