package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.databinding.FragmentDetailMealBinding
import com.thechance.nutritionsapp.util.Constants
import kotlin.text.StringBuilder

class DetailMealFragment : BaseFragment<FragmentDetailMealBinding>() {
    private lateinit var mMealDetails: HealthyFood

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailMealBinding =
        FragmentDetailMealBinding::inflate

    override fun setup() {
        setupActionBar(
            toolbar = binding.detailToolbar.toolbar,
            title = getString(R.string.meal_details)
        )
        mMealDetails = arguments?.getParcelable(Constants.EXTRA_MEAL_DETAILS)!!

        setData()
    }

    private fun setData() {
        binding.mealTitleTv.text = mMealDetails.name
        binding.carbGramTv.text = resources.getString(R.string.carb_gram, mMealDetails.carbs)
        binding.carbProgressBar.progress = mMealDetails.carbs.toInt()
        binding.proteinGramTv.text =
            resources.getString(R.string.protein_gram, mMealDetails.protein)
        binding.proteinProgressBar.progress = mMealDetails.protein.toInt()
        binding.fatGramTv.text = resources.getString(
            R.string.fat_gram, mMealDetails.fat
        )
        binding.fatProgressBar.progress = mMealDetails.fat.toInt()
        binding.servingsNumberTv.text = resources.getString(
            R.string.servings_number,
            mMealDetails.servings.toString()
        )
        binding.ingredientsTv.text = resources.getString(
            R.string.ingredients,
            mMealDetails.calorie.toString()
        )

        val ingredientStr = StringBuilder()
        mMealDetails.ingredients.forEach {
            ingredientStr.appendLine(it)
        }
        binding.recipeTv.text = ingredientStr

        val preparationStr = StringBuilder()
        mMealDetails.preparation.forEach { preparationStr.appendLine(it) }
        binding.preparationStepTv.text = preparationStr

        val imageId =
            resources.getIdentifier(mMealDetails.image, "drawable", requireActivity().packageName)
        binding.mealIv.setImageResource(imageId)
    }

    override fun getData() {
        TODO("Not yet implemented")
    }

    override fun addDataToBundle() {
        TODO("Not yet implemented")
    }
}