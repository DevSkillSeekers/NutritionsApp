package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding
import com.thechance.nutritionsapp.ui.meal.MealFragment
import com.thechance.nutritionsapp.util.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
    private var healthySuggestionMeal = listOf<HealthyFood>()
    private var totalCaloriesPerMeal = 0
    private var listMealItem = ArrayList<NutritionItem>()

    override fun setup() {
        binding.totalCaloriesDayTv.text = dataManager.getRemainderCaloriesPerDay().toString()
        binding.trackCarb.text = dataManager.getRemainderCarbsPerDay().toString() + "g"
        binding.trackProtein.text = dataManager.getRemainderProteinsPerDay().toString() + "g"
        binding.trackFat.text = dataManager.getRemainderFatsPerDay().toString() + "g"
        binding.progressBar.progress = dataManager.getProgressCalories()
        binding.carbProgressBar.progress = dataManager.getProgressCarbs().toInt()
        binding.proteinsProgressBar.progress = dataManager.getProgressProtein().toInt()
        binding.fatProgressBar.progress = dataManager.getProgressFat().toInt()
        when {
            Constants.MAX_CARBS_PER_DAY == Constants.StandardDiet.MAX_CARBS_PER_DAY -> binding.dietType.text = "Standard Diet"
            Constants.MAX_CARBS_PER_DAY == Constants.KetoDiet.MAX_CARBS_PER_DAY -> binding.dietType.text = "Ketogenic Diet"
            Constants.MAX_CARBS_PER_DAY == Constants.HighProteinDiet.MAX_CARBS_PER_DAY -> binding.dietType.text = "High-Protein Diet"
            Constants.MAX_CARBS_PER_DAY == Constants.MediterraneanDiet.MAX_CARBS_PER_DAY -> binding.dietType.text = "Mediterranean Diet"
        }
        when (mealType) {
            Constants.BREAKFAST -> {
                binding.breakfastChip.isChecked = true
            }
            Constants.LUNCH -> {
                binding.lunchChip.isChecked = true
            }
            Constants.DINNER -> {
                binding.dinnerChip.isChecked = true
            }
        }
        updateView()
        setListeners()
    }

    private fun updateView() {
        setMeal()
        setSuggestionMeal()
        setMealItems()
    }

    private fun setListeners() {
        binding.mealChipGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.breakfastChip -> {
                    mealType = Constants.BREAKFAST
                    updateView()
                }
                R.id.lunchChip -> {
                    mealType = Constants.LUNCH
                    updateView()
                }
                R.id.dinnerChip -> {
                    mealType = Constants.DINNER
                    updateView()
                }
            }
        }

        binding.recipes.recipe1.setOnClickListener {
            goToDetailView(healthySuggestionMeal[0])
        }
        binding.recipes.recipe2.setOnClickListener {
            goToDetailView(healthySuggestionMeal[1])
        }
        binding.recipes.recipe3.setOnClickListener {
            goToDetailView(healthySuggestionMeal[2])
        }
        binding.seeAllTv.setOnClickListener {
            goToMealItemsView()
        }
    }

    private fun setMeal() {
        when (mealType) {
            Constants.BREAKFAST -> {
                binding.mealTv.text = resources.getString(R.string.breakfast)
            }
            Constants.LUNCH -> {
                binding.mealTv.text = resources.getString(R.string.lunch)
            }
            Constants.DINNER -> {
                binding.mealTv.text = resources.getString(R.string.dinner)
            }
        }
        healthySuggestionMeal = dataManager.getHealthyMeal(mealType)
        listMealItem = ArrayList(dataManager.getMeals(mealType))
        totalCaloriesPerMeal = dataManager.getMealCalories(mealType)
    }

    private fun setMealItems() {
        binding.totalCaloriesAmountTv.text = resources.getString(
            R.string.calories_number,
            totalCaloriesPerMeal.toString()
        )

        if (listMealItem.isNotEmpty()) {
            binding.noItemTv.visibility = View.GONE
            binding.totalCaloriesTv.visibility = View.VISIBLE
            binding.totalCaloriesAmountTv.visibility = View.VISIBLE
            binding.meal1.root.visibility = View.VISIBLE
            binding.meal1.mealNameTv.text = listMealItem.first().name
            binding.meal1.amountTv.text = listMealItem.first().servingSize
            binding.meal1.calsAmountTv.text = listMealItem.first().calories.toString()

            if (listMealItem.count() > 1) {
                binding.meal2.root.visibility = View.VISIBLE
                binding.meal2.mealNameTv.text = listMealItem[1].name
                binding.meal2.amountTv.text = listMealItem[1].servingSize
                binding.meal2.calsAmountTv.text = listMealItem[1].calories.toString()
            }
        } else {
            binding.noItemTv.visibility = View.VISIBLE
            binding.totalCaloriesTv.visibility = View.GONE
            binding.totalCaloriesAmountTv.visibility = View.GONE
            binding.meal1.root.visibility = View.GONE
            binding.meal2.root.visibility = View.GONE
        }
    }

    private fun goToDetailView(healthMeal: HealthyFood?) {
        val fragment = DetailMealFragment()
        val data = Bundle()
        data.putParcelable(Constants.EXTRA_MEAL_DETAILS, healthMeal)
        fragment.arguments = data
        changeFragmentWithData(
            fragment,
            Constants.ADD_FRAGMENT,
            data
        )
    }

    private fun goToMealItemsView() {
        val fragment = MealFragment()
        changeFragmentWithData(
            fragment,
            Constants.ADD_FRAGMENT,
            Bundle()
        )
    }

    private fun setSuggestionMeal() {
        binding.recipes.healthyFoodTv.text = healthySuggestionMeal[0].name
        binding.recipes.healthyFoodImgV.setImageDrawable(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.pesto_chicken_zoodles
            )
        )

        binding.recipes.healthyFoodTv2.text = healthySuggestionMeal[1].name
        binding.recipes.healthyFoodImgV.setImageDrawable(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.salmon_caesar_salad
            )
        )

        binding.recipes.healthyFoodTv3.text = healthySuggestionMeal[2].name
        binding.recipes.healthyFoodImgV.setImageDrawable(
            ContextCompat.getDrawable(
                requireActivity(),
                R.drawable.salmon_caesar_salad
            )
        )
    }

}