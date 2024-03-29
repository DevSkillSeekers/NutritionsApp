package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.DietValues
import com.thechance.nutritionsapp.databinding.FragmentBMIBinding
import com.thechance.nutritionsapp.databinding.FragmentDietTypeBinding
import com.thechance.nutritionsapp.util.Constants

class DietTypeFragment: BaseFragment<FragmentDietTypeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDietTypeBinding =
        FragmentDietTypeBinding::inflate

    override fun setup() {
        setupActionBar(
            toolbar = binding.dietTypesToolbar.toolbar,
            title = resources.getString(R.string.dietType)
        )

        binding.dietTypes.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.standard -> {
                    binding.dietTypeHeadline.text = getString(R.string.standardHeadline)
                    binding.info.text = getString(R.string.standardDiet)
                    DietValues.MAX_CARBS_PER_DAY = Constants.StandardDiet.MAX_CARBS_PER_DAY
                    DietValues.MAX_PROTEINS_PER_DAY = Constants.StandardDiet.MAX_PROTEINS_PER_DAY
                    DietValues.MAX_FATS_PER_DAY = Constants.StandardDiet.MAX_FATS_PER_DAY
                }
                R.id.ketogenic -> {
                    binding.dietTypeHeadline.text = getString(R.string.ketoHeadline)
                    binding.info.text = getString(R.string.ketoDiet)
                    DietValues.MAX_CARBS_PER_DAY = Constants.KetoDiet.MAX_CARBS_PER_DAY
                    DietValues.MAX_PROTEINS_PER_DAY = Constants.KetoDiet.MAX_PROTEINS_PER_DAY
                    DietValues.MAX_FATS_PER_DAY = Constants.KetoDiet.MAX_FATS_PER_DAY
                }
                R.id.highProtein -> {
                    binding.dietTypeHeadline.text = getString(R.string.highProteinHeadline)
                    binding.info.text = getString(R.string.highProteinDiet)
                    DietValues.MAX_CARBS_PER_DAY = Constants.HighProteinDiet.MAX_CARBS_PER_DAY
                    DietValues.MAX_PROTEINS_PER_DAY = Constants.HighProteinDiet.MAX_PROTEINS_PER_DAY
                    DietValues.MAX_FATS_PER_DAY = Constants.HighProteinDiet.MAX_FATS_PER_DAY
                }
                R.id.mediterranean -> {
                    binding.dietTypeHeadline.text = getString(R.string.mediterraneanHeadline)
                    binding.info.text = getString(R.string.mediterraneanDiet)
                    DietValues.MAX_CARBS_PER_DAY = Constants.MediterraneanDiet.MAX_CARBS_PER_DAY
                    DietValues.MAX_PROTEINS_PER_DAY = Constants.MediterraneanDiet.MAX_PROTEINS_PER_DAY
                    DietValues.MAX_FATS_PER_DAY = Constants.MediterraneanDiet.MAX_FATS_PER_DAY
                }
            }
        }
    }

}