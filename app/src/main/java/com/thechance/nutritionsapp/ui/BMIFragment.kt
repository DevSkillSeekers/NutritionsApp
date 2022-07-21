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
//        setupActionBar(
//            toolbar = binding.bmiToolbar.toolbar,
//            title = resources.getString(R.string.bmi)
//        )
//
//        binding.heightInputView.setAdapter(
//            ArrayAdapter(
//                requireContext(),
//                android.R.layout.simple_dropdown_item_1line, listOf(
//                    resources.getString(R.string.cm_text),
//                    resources.getString(R.string.feet)
//                )
//            )
//        )
//
//        binding.weightInputView.setAdapter(
//            ArrayAdapter(
//                requireContext(),
//                android.R.layout.simple_dropdown_item_1line, listOf(
//                    resources.getString(R.string.kg_text),
//                    resources.getString(R.string.pound)
//                )
//            )
//        )
//
//        binding.calculateBT.setOnClickListener {
//            if (!binding.WeightTIET.text.isNullOrBlank() && !binding.heightTIET.text.isNullOrBlank()) {
//                val weight = binding.WeightTIET.text.toString().toDouble()
//                val height = binding.heightTIET.text.toString().toDouble()
//                val weighUnit = binding.menuWeightACTV.text.toString()
//                val heightUnit = binding.menuHeightACTV.text.toString()
//                calculateBMI(weight, height, weighUnit, heightUnit)
//            } else {
//                Toast.makeText(context, "Please enter your weight and height", Toast.LENGTH_LONG)
//                    .show()
//            }
//        }
//    }
//
//    private fun calculateBMI(
//        weight: Double,
//        height: Double,
//        weighUnit: String,
//        heightUnit: String
//    ) {
//        var heightCM = height
//        if (heightUnit != resources.getString(R.string.cm_text)) {
//            heightCM = Converter().convertFromTypeToOther(
//                ConverterUtil.MainConverter.weight,
//                "feet",
//                "cm",
//                height
//            ) ?: height
//        }
//        var weightKG = weight
//        if (weighUnit != resources.getString(R.string.kg_text)) {
//            weightKG = Converter().convertFromTypeToOther(
//                ConverterUtil.MainConverter.weight,
//                "Pound",
//                "Kilogram",
//                height
//            ) ?: weight
//        }
//
//        val bmiCalculator = BMI(weightKG, heightCM)
//        val result = bmiCalculator.calculation0fBMI()
//        binding.ArcProgress.progress = result.toInt()
//        val type = bmiCalculator.diagnostic(result)
//        binding.displayResultTv.text = type
//        binding.linearLayout.visibility = View.VISIBLE
    }

}