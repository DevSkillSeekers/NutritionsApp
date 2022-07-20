package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentBMIBinding
import com.thechance.nutritionsapp.util.BMI
import com.thechance.nutritionsapp.util.unitconverter.Converter

class BMIFragment : BaseFragment<FragmentBMIBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBMIBinding =
        FragmentBMIBinding::inflate

    override fun setup() {
        setupActionBar(
            toolbar = binding.bmiToolbar.toolbar,
            title = resources.getString(R.string.bmi)
        )

        binding.heightInputView.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line, listOf(
                    resources.getString(R.string.cm_text),
                    resources.getString(R.string.feet)
                )
            )
        )

        binding.weightInputView.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line, listOf(
                    resources.getString(R.string.kg_text),
                    resources.getString(R.string.pound)
                )
            )
        )

        binding.calculateBT.setOnClickListener {
//            this.hideKeyboard()
            if (!binding.WeightTIET.text.isNullOrBlank() && !binding.heightTIET.text.isNullOrBlank()) {
                val weight = binding.WeightTIET.text.toString().toDoubleOrNull() ?: 0.0
                val height = binding.heightTIET.text.toString().toDoubleOrNull() ?: 0.0
                val weighUnit = binding.weightInputView.text.toString()
                val heightUnit = binding.heightInputView.text.toString()
               // calculateBMI(weight, height, weighUnit, heightUnit)
            } else {
                Toast.makeText(context,resources.getString(R.string.error_msg), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun calculateBMI(
        weight: Double,
        height: Double,
        weighUnit: String,
        heightUnit: String
    ) {
        var heightCM = height
        if (heightUnit != resources.getString(R.string.cm_text)) {
            heightCM = Converter().feetToCm(height)
        }
        var weightKG = weight
        if (weighUnit != resources.getString(R.string.kg_text)) {
            weightKG = Converter().poundToKilo(weight)
        }

        val bmiCalculator = BMI(weightKG, heightCM)
        val result = bmiCalculator.calculation0fBMI()
        binding.ArcProgress.progress = result.toInt()
        val type = bmiCalculator.diagnostic(result)
        binding.displayResultTv.text = type
        binding.linearLayout.visibility = View.VISIBLE
    }

}