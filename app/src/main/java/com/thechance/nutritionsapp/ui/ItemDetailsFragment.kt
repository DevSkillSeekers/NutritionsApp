package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentItemDetailsBinding
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.unitconverter.Converter
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
                var item = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireActivity(), "item: $item", Toast.LENGTH_SHORT).show()
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

        itemUnit = mNutritionDetails.cholesterol.replace("[^A-Za-z]".toRegex(), "")
        amountOfNutritionItem = mNutritionDetails.cholesterol.replace("mg", "").toDouble()
        result = nutritional.calcultionOfNuTritionFacts(
            amountOfNutritionItem,
            servingNumber,
            DropDownUnit
        )
        binding.cholesterolAmount.text = String.format("%.02f", result) + itemUnit


    }
}



