package com.thechance.nutritionsapp.ui

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.compose.ui.Modifier
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentBMIBinding
import com.thechance.nutritionsapp.util.BMI
import com.thechance.nutritionsapp.util.unitconverter.Converter
import com.thechance.nutritionsapp.util.unitconverter.ConverterUtil

class BMIFragment : BaseFragment<FragmentBMIBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBMIBinding =
        FragmentBMIBinding::inflate

    override fun setup() {
        this.setupActionBar(
            toolbar = binding.bmiToolbar.toolbar,
            title = resources.getString(R.string.bmi)
        )
         //  Adapter for height menu
        binding.menuHeightACTV.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line, listOf(
                    resources.getString(R.string.cm_text),
                    resources.getString(R.string.feet)
                )
            )
        )
        //  Adapter for weight menu
        binding.menuWeightACTV.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line, listOf(
                    resources.getString(R.string.kg_text),
                    resources.getString(R.string.pound)
                )
            )
        )
        //  when click on calculate Button
        binding.calculateBT.setOnClickListener {
            if (!binding.WeightTIET.text.isNullOrBlank()
                && !binding.heightTIET.text.isNullOrBlank()
                && (binding.WeightTIET.text.toString().toDouble() in 40.0..132.0)
               && (binding.heightTIET.text.toString().toDouble() in 140.0..210.0)

            ) {
                val weight = binding.WeightTIET.text.toString().toDouble()
                val height = binding.heightTIET.text.toString().toDouble()
                val weighUnit = binding.menuWeightACTV.text.toString()
                val heightUnit = binding.menuHeightACTV.text.toString()
                calculateBMI(weight, height, weighUnit, heightUnit)
            } else {
                Toast.makeText(context, "Please enter your weight:between(40-132) and height:between(140-210)", Toast.LENGTH_LONG)
                    .show()
                binding.WeightTIET.setText("")
                binding.heightTIET.setText("")

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
            heightCM = Converter().convertFromTypeToOther(
                ConverterUtil.MainConverter.weight,
                "feet",
                "cm",
                height
            ) ?: height
        }
        var weightKG = weight
        if (weighUnit != resources.getString(R.string.kg_text)) {
            weightKG = Converter().convertFromTypeToOther(
                ConverterUtil.MainConverter.weight,
                "Pound",
                "Kilogram",
                height
            ) ?: weight
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
                    binding.displayTipsTV.setText(R.string.tips)
                    binding.displayResultTv.setTextColor(resources.getColor(R.color.color_yellow))}
                in 18.50..24.99 -> {
                        binding.ArcProgress.finishedStrokeColor = (resources.getColor(R.color.blue))
                        binding.displayTipsTV.setText(R.string.tips)
                        binding.displayResultTv.setTextColor(resources.getColor(R.color.blue))
                }

                in 25.0..40.0 -> {
                    binding.ArcProgress.finishedStrokeColor = (resources.getColor(R.color.color_red))
                    binding.displayTipsTV.setText(R.string.tips)
                    binding.displayResultTv.setTextColor(resources.getColor(R.color.color_red))}
                }
            }else{
            Toast.makeText(context, "Please make sure that you enter the correct values ", Toast.LENGTH_LONG).show()
            }
    }
}