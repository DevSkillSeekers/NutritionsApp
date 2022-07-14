package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentBMIBinding
import com.thechance.nutritionsapp.util.BMI

class BMIFragment : BaseFragment<FragmentBMIBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBMIBinding =
        FragmentBMIBinding::inflate
//
    private var weight = binding.WeightTIET.text.toString().toDouble()
    var height = binding.WeightTIET.text.toString().toDouble()
    private val menuWeightACTV = binding.menuWeightACTV
    private val menuHeightACTV = binding.menuHeightACTV
    private val calculateBT = binding.calculateBT
    private var arcProgress = binding.ArcProgress
    private var resultTV = binding.resultTV
    var tipsTV = binding.tipsTV.text
    var resultBmiNum: Double = 0.0

    override fun setup() {
        //DROP_DOWN_MENU
        //1 git string array
        val unitWeight = resources.getStringArray(R.array.unit_weight)
        val unitHeight = resources.getStringArray(R.array.unit_height)
        //2 make adapter for Weight and height
        val adapterWeight = ArrayAdapter(requireActivity(), R.layout.dropdown_item, unitWeight)
        val adapterHeight = ArrayAdapter(requireActivity(), R.layout.dropdown_item, unitHeight)
        //3 put adapter on menu & take the selected and put in a variable
        val unitFroWeightMnue = menuWeightACTV.setAdapter(adapterWeight).toString()
        val unitFroHeightMnue = menuHeightACTV.setAdapter(adapterHeight).toString()

        //check the unit before sending to class BMI
        if(unitFroWeightMnue=="pound"){ weight *= 0.454 }
        if(unitFroHeightMnue=="inch"){ height *= 254 }

        //send values to class BMI
        val  bmiResult = BMI(weight, height)


        //when click on calculate button
        calculateBT.setOnClickListener {

            //change the resultText & progressBar
           //1 change the resultText
            resultTV.text = bmiResult.diagnostic()
            //2 change the progressBar
            resultBmiNum = bmiResult.calculation0fBMI()
            arcProgress.progress = resultBmiNum.toInt()

            // when click on calculate button also change -> color resultTV , tips text , color progress bar
            if (resultBmiNum != -1.0) {
                when (resultBmiNum) {
                    in 16.0..18.49 -> {
                        resultTV.setTextColor(ContextCompat.getColor(requireContext(),R.color.blue))
                        arcProgress.finishedStrokeColor = R.color.blue
                        tipsTV=getString(R.string.tips_Normal_weight)

                    }
                    in 18.50..24.99 -> {
                        resultTV.setTextColor(ContextCompat.getColor(requireContext(),R.color.color_yellow))
                        arcProgress.finishedStrokeColor = R.color.color_yellow
                        tipsTV=getString(R.string.tips_Low_weight)

                    }
                    in 25.0..40.0 -> {
                        resultTV.setTextColor(ContextCompat.getColor(requireContext(),R.color.color_red))
                        arcProgress.finishedStrokeColor = R.color.color_red
                        tipsTV=getString(R.string.tips)
                    }
                }
            }

        }
    }


}