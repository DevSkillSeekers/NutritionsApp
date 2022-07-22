package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Toast
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentItemDetailsBinding
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.unitconverter.NutrationFacts


class ItemDetailsFragment : BaseFragment<FragmentItemDetailsBinding>() {
    private lateinit var mNutritionDetails: NutritionItem

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentItemDetailsBinding =
        FragmentItemDetailsBinding::inflate

    override fun setup() {
        mNutritionDetails = arguments?.getParcelable(Constants.EXTRA_NUTRITION_DETAILS)!!
        setupActionBar(binding.toolbarItemDetails.toolbar, mNutritionDetails.name)

        val items = listOf("kg", "g", "mg", "lb")
        val adapter = ArrayAdapter(requireActivity(), R.layout.dropdown_item, items)
        binding.autoCompleteTextView.setAdapter(adapter)
        setData()
        binding.autoCompleteTextView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                  if (binding.servingsNumber.text.toString().isNotEmpty()) {
                    setNutritionFacts()
                 }
            }
        binding.servingsNumber.onFocusChangeListener =
            OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus && binding.servingsNumber.text.toString()
                        .isNotEmpty() && binding.autoCompleteTextView.text.isNotEmpty()
                )
                    setNutritionFacts()
             }


    }

    private fun setData() {

        binding.progressBarOfCarb.progress = (mNutritionDetails.carbs).toInt()
        binding.progressBarOfProtein.progress = (mNutritionDetails.proteins).toInt()
        binding.fatProgressBarOfFats.progress = (mNutritionDetails.fats).toInt()
        binding.circularProgressBar.progress = mNutritionDetails.calories

        binding.KcalAmount.text =
            mNutritionDetails.calories.toString().replace("gram", "")

        binding.carbAmount.text =
            (mNutritionDetails.carbs).toString() + "g"

        binding.proteinAmount.text =
            (mNutritionDetails.proteins).toString() + "g"

        binding.fatsAmount.text =
            (mNutritionDetails.fats).toString() + "g"

    }


    fun setNutritionFacts() {
        val servingNumber: Double = binding.servingsNumber.text.toString().toDouble()
        val DropDownUnit = binding.autoCompleteTextView.text.toString()
        var itemUnit = mNutritionDetails.fiber.replace("[^A-Za-z]".toRegex(), "")
        val nutritional = NutrationFacts()

        var amountOfNutritionItem: Double = mNutritionDetails.fiber.replace("g", "").toDouble()
        var result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.fiberAmount.text = String.format("%.02f", result) + itemUnit

        itemUnit = mNutritionDetails.iron.replace("[^A-Za-z]".toRegex(), "")
        amountOfNutritionItem = mNutritionDetails.iron.replace("mg", "").toDouble()
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.ironAmount.text = String.format("%.02f", result) + itemUnit

        itemUnit = mNutritionDetails.vitamin_c.replace("[^A-Za-z]".toRegex(), "")
        amountOfNutritionItem = mNutritionDetails.vitamin_c.replace("mg", "").toDouble()
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.vitaminCAmount.text = String.format("%.02f", result) + itemUnit

        amountOfNutritionItem = mNutritionDetails.cholesterol.replace("mg", "").toDouble()
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.cholesterolAmount.text = String.format("%.02f", result) + "mg"

        amountOfNutritionItem = mNutritionDetails.carbs
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.progressBarOfCarb.max = servingNumber.toInt()
        binding.progressBarOfCarb.progress = result.toInt()
        binding.carbAmount.text = String.format("%.02f", result) + "g"

        amountOfNutritionItem = mNutritionDetails.proteins
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.progressBarOfProtein.max = servingNumber.toInt()
        binding.progressBarOfProtein.progress = result.toInt()
        binding.proteinAmount.text = String.format("%.02f", result) + "g"

        amountOfNutritionItem = mNutritionDetails.fats
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.fatProgressBarOfFats.max = servingNumber.toInt()
        binding.fatProgressBarOfFats.progress = result.toInt()
        binding.fatsAmount.text = String.format("%.02f", result) + "g"

        amountOfNutritionItem = mNutritionDetails.calories.toDouble()
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )

        binding.circularProgressBar.progress = result.toInt()
        binding.KcalAmount.text =  result.toInt().toString()

 
    }
}



