package com.thechance.nutritionsapp.ui

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.compose.ui.Modifier
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

            if (!binding.WeightTIET.text.isNullOrBlank()
                && !binding.heightTIET.text.isNullOrBlank()
                && (binding.WeightTIET.text.toString().toDouble() in 40.0..132.0)
                && (binding.heightTIET.text.toString().toDouble() in 140.0..210.0)
            ) {
                val weight = binding.WeightTIET.text.toString().toDoubleOrNull() ?: 0.0
                val height = binding.heightTIET.text.toString().toDoubleOrNull() ?: 0.0
                val weighUnit = binding.weightInputView.text.toString()
                val heightUnit = binding.heightInputView.text.toString()
             calculateBMI(weight, height, weighUnit, heightUnit)
            } else {
                Toast.makeText(context, "Please enter your  weight:between(40-132)  and  height:between(140-210)", Toast.LENGTH_LONG)
                    .show()
                binding.WeightTIET.setText("")
                binding.heightTIET.setText("")
                binding.ArcProgress.progress = 0
                binding.displayResultTv.text = ""
                binding.displayNumResultTv.text=""
                binding.displayTipsTV.text=""

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

        // display the result
        binding.displayTipsTV.movementMethod = ScrollingMovementMethod()
        val bmiCalculator = BMI(weightKG, heightCM)
        val result = bmiCalculator.calculation0fBMI()

        if (result != -1.0) {
            binding.ArcProgress.progress = result.toInt()
            val type = bmiCalculator.diagnostic(result)
            binding.displayResultTv.text = type
            binding.displayNumResultTv.text=result.toString()
            when (result) {
                in 0.0..18.49 -> {
                    binding.ArcProgress.finishedStrokeColor=(resources.getColor(R.color.color_yellow))
                    binding.displayTipsTV.setText(R.string.tips_low_weight)
                    binding.displayResultTv.setTextColor(resources.getColor(R.color.color_yellow))}
                in 18.50..24.99 -> {
                        binding.ArcProgress.finishedStrokeColor = (resources.getColor(R.color.blue))
                        binding.displayTipsTV.setText(R.string.tips_normal_weight)
                        binding.displayResultTv.setTextColor(resources.getColor(R.color.blue))
                }

                in 25.0..40.0 -> {
                    binding.ArcProgress.finishedStrokeColor = (resources.getColor(R.color.color_red))
                    binding.displayTipsTV.setText(R.string.tips_over_weight)
                    binding.displayResultTv.setTextColor(resources.getColor(R.color.color_red))}
                }
            }else{
            Toast.makeText(context, "Please make sure that you enter the correct values ", Toast.LENGTH_LONG).show()
            }
    }
}