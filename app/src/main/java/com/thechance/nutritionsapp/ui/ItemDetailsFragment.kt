package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.text.set
import com.google.android.material.snackbar.Snackbar
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.DietValues
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentItemDetailsBinding
import com.thechance.nutritionsapp.ui.home.HomeFragment
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.hideKeyboard
import com.thechance.nutritionsapp.util.unitconverter.NutrationFacts


class ItemDetailsFragment : BaseFragment<FragmentItemDetailsBinding>() {
    private lateinit var mNutritionDetails: NutritionItem
    var servingNumber: Double=100.0
    var DropDownUnit="g"
    var totalKcal =0
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentItemDetailsBinding =
        FragmentItemDetailsBinding::inflate

    override fun setup() {
        mNutritionDetails = arguments?.getParcelable(Constants.EXTRA_NUTRITION_DETAILS)!!
        setupActionBar(binding.toolbarItemDetails.toolbar, mNutritionDetails.name)

        val items = listOf("kg", "g", "mg", "lb")
        val adapter = ArrayAdapter(requireActivity(), R.layout.dropdown_item, items)
        binding.autoCompleteTextView.setText(items[1])
        binding.autoCompleteTextView.setAdapter(adapter)
        setData()
        binding.autoCompleteTextView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                if (binding.servingsNumber.text.toString().isNotEmpty()) {
                    setNutritionFacts()
                }
            }
        binding.servingsNumber.setText("100")
        binding.servingsNumber.onFocusChangeListener =
            OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus && binding.servingsNumber.text.toString()
                        .isNotEmpty() && binding.autoCompleteTextView.text.isNotEmpty()
                )
                    setNutritionFacts()
            }
        binding.buttonAddMeal.setOnClickListener {
            addItem()
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


    private fun setNutritionFacts() {
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
        binding.KcalAmount.text = result.toInt().toString()
        totalKcal =result.toInt()
    }

    private fun addItem() {
        mNutritionDetails.servingSize= "$servingNumber $DropDownUnit"
        mNutritionDetails.calories = if( totalKcal!=0)totalKcal else mNutritionDetails.calories
        var msg = ""
        when (mealType) {
            Constants.BREAKFAST -> {
                when {
                    mNutritionDetails.calories > DietValues.remainderCal -> {
                        msg = "Oops, you don`t have enough remained calories"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.carbs > DietValues.remainderCarb -> {
                        msg = "Oops, you don`t have enough remained carbs"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.proteins > DietValues.remainderProtein -> {
                        msg = "Oops, you don`t have enough remained protein"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.fats > DietValues.remainderFat -> {
                        msg = "Oops, you don`t have enough remained fat"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> breakfast.add(mNutritionDetails)
                }
            }
            Constants.LUNCH -> {
                when {
                    mNutritionDetails.calories > DietValues.remainderCal -> {
                        msg = "Oops, you don`t have enough remained calories"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.carbs > DietValues.remainderCarb -> {
                        msg = "Oops, you don`t have enough remained carbs"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.proteins > DietValues.remainderProtein -> {
                        msg = "Oops, you don`t have enough remained protein"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.fats > DietValues.remainderFat -> {
                        msg = "Oops, you don`t have enough remained fat"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> lunch.add(mNutritionDetails)
                }
            }
            Constants.DINNER -> {
                when {
                    mNutritionDetails.calories > DietValues.remainderCal -> {
                        msg = "Oops, you don`t have enough reminded calories"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.carbs > DietValues.remainderCarb -> {
                        msg = "Oops, you don`t have enough reminded carbs"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.proteins > DietValues.remainderProtein -> {
                        msg = "Oops, you don`t have enough reminded protein"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    mNutritionDetails.fats > DietValues.remainderFat -> {
                        msg = "Oops, you don`t have enough reminded fat"
                        Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
                    }
                    else -> dinner.add(mNutritionDetails)
                }
            }
        }
        this.hideKeyboard()
        val fragment = HomeFragment()
        changeFragmentWithData(
            fragment,
            Constants.ADD_FRAGMENT,
            Bundle()
        )
    }

}



