package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.data.domain.Meal
import com.thechance.nutritionsapp.databinding.FragmentDetailMealBinding
import com.thechance.nutritionsapp.util.Constants

class DetailMealFragment : BaseFragment<FragmentDetailMealBinding>() {
    private lateinit var mMealDetails: Meal

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailMealBinding =
        FragmentDetailMealBinding::inflate

    override fun setup() {
        TODO("set correct title")
        this.setupActionBar(toolbar = binding.detailToolbar.toolbar, title = "Meal Details")

        setData()
    }

    private fun setData() {
        // Retrieve the meal details from intent extra.
        if (requireActivity().intent.hasExtra(Constants.EXTRA_MEAL_DETAILS)) {
            mMealDetails =
                requireActivity().intent.getParcelableExtra(Constants.EXTRA_MEAL_DETAILS)!!

            binding.mealTitleTv.text = mMealDetails.title
            binding.carbGramTv.text = mMealDetails.carb
            binding.carbProgressBar.progress = mMealDetails.carb.toInt()
            binding.proteinGramTv.text = mMealDetails.protein
            binding.proteinProgressBar.progress = mMealDetails.protein.toInt()
            binding.fatGramTv.text = mMealDetails.fat
            binding.fatProgressBar.progress = mMealDetails.fat.toInt()
            binding.servingsNumberTv.text = mMealDetails.servingSize
            binding.preparationStepTv.text = mMealDetails.preparationSteps
        }
        TODO("set image")
        TODO("handle gram keyword")
        TODO("adjust ProgressBar color")
        TODO("try %s with text")
    }
}