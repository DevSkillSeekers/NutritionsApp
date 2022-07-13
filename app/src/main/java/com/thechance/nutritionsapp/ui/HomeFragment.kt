package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding
import com.thechance.nutritionsapp.util.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
    private lateinit var dataManager: DataManager

    private var meal = Constants.BREAKFAST
    private var healthySuggestionMeal = listOf<HealthyFood>()
    private var totalCaloriesPerMeal = 0
    private var listMealItem = listOf<NutritionItem>()

    override fun setup() {
        dataManager = DataManager(requireContext())
        binding.totalCaloriesDayTv.text = dataManager.getRemainderCaloriesPerDay().toString()
        binding.progressBar.progress = dataManager.getProgressCalories()
        binding.carbProgressBar.progress = dataManager.getProgressCarbs()
        binding.proteinsProgressBar.progress = dataManager.getProgressProtein()
        binding.fatProgressBar.progress = dataManager.getProgressFat()
        updateView()
        setListeners()
    }

    private fun updateView(){
        setMeal(meal)
        setSuggestionMeal()
        setMealItems(meal)
    }

    private fun setListeners() {
        binding.mealChipGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
               R.id.breakfastChip ->{
                    meal = Constants.BREAKFAST
                   updateView()
               }
                R.id.lunchChip->{
                    meal = Constants.LUNCH
                    updateView()
                }
                R.id.dinnerChip->{
                    meal = Constants.DINNER
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

    private fun setMeal(meal: Int) {
        when (meal) {
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
        healthySuggestionMeal = dataManager.getHealthyMeal(meal)
        listMealItem = dataManager.getMeals(meal)
        totalCaloriesPerMeal = dataManager.getMealCalories(meal)
    }

    private fun setMealItems(meal: Int) {
        binding.totalCaloriesAmountTv.text = resources.getString(
            R.string.calories_number,
            totalCaloriesPerMeal.toString()
        )

        if (listMealItem.isNotEmpty()) {
            binding.noItemTv.visibility = View.GONE
            binding.totalCaloriesTv.visibility= View.VISIBLE
            binding.totalCaloriesAmountTv.visibility=View.VISIBLE
            binding.meal1.root.visibility = View.VISIBLE
            binding.meal1.mealNameTv.text = listMealItem.first().name
            binding.meal1.amountTv.text = listMealItem.first().servingSize
            binding.meal1.calsTv.text = listMealItem.first().calories.toString()

            if (listMealItem.count() > 1) {
                binding.meal2.root.visibility = View.VISIBLE
                binding.meal2.mealNameTv.text = listMealItem[1].name
                binding.meal2.amountTv.text = listMealItem[1].servingSize
                binding.meal2.calsTv.text = listMealItem[1].calories.toString()
            }
        } else {
            binding.noItemTv.visibility = View.VISIBLE
            binding.totalCaloriesTv.visibility= View.GONE
            binding.totalCaloriesAmountTv.visibility=View.GONE
        }
    }

    private fun goToDetailView(healthMeal: HealthyFood?) {
        val fragment = DetailMealFragment()
        val data = Bundle()
        data.putParcelable(Constants.EXTRA_MEAL_DETAILS, healthMeal)
        fragment.arguments = data
        changeFragment(
            requireActivity() as AppCompatActivity,
            fragment,
            Constants.ADD_FRAGMENT
        )
    }

    private fun goToMealItemsView() {
        val fragment = MealFragment()
//        val data = Bundle()
//        data.putParcelable(Constants.MEAL_ITEMS_DATA, meal)
//        fragment.arguments = data
        changeFragment(
            requireActivity() as AppCompatActivity,
            fragment,
            Constants.ADD_FRAGMENT
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