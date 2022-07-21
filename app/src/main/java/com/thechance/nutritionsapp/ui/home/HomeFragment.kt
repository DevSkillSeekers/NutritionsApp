package com.thechance.nutritionsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.DietValues
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding
import com.thechance.nutritionsapp.ui.BaseFragment
import com.thechance.nutritionsapp.ui.DetailMealFragment
import com.thechance.nutritionsapp.ui.meal.MealAdapter
import com.thechance.nutritionsapp.ui.meal.MealFragment
import com.thechance.nutritionsapp.util.Constants

class HomeFragment : BaseFragment<FragmentHomeBinding>(),HealthyFoodAdapter.OnClickListener {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
    private var healthySuggestionMeal = listOf<HealthyFood>()
    private var totalCaloriesPerMeal = 0
    private var listMealItem = ArrayList<NutritionItem>()
    private var mealAdapter: MealItemAdapter? = null
    private var healthyFoodAdapter: HealthyFoodAdapter? = null

    override fun setup() {
        binding.textTotalCaloriesDay.text = dataManager.getRemainderCaloriesPerDay().toString()
        binding.trackCarb.text = dataManager.getRemainderCarbsPerDay().toString() + "g"
        binding.textTrackProtein.text = dataManager.getRemainderProteinsPerDay().toString() + "g"
        binding.textTrackFat.text = dataManager.getRemainderFatsPerDay().toString() + "g"
        binding.progressBar.progress = dataManager.getProgressCalories()
        binding.carbProgressBar.progress = dataManager.getProgressCarbs().toInt()
        binding.proteinsProgressBar.progress = dataManager.getProgressProtein().toInt()
        binding.fatProgressBar.progress = dataManager.getProgressFat().toInt()

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
        setMealItems()
        setSuggestionFood()
    }

    private fun setSuggestionFood() {
        binding.listHealthyRecipes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        healthyFoodAdapter = HealthyFoodAdapter(healthySuggestionMeal,this)
        binding.listHealthyRecipes.adapter = healthyFoodAdapter
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

        binding.cardMealItem.setOnClickListener{
            goToMealItemsView()
        }

        binding.textSeeAll.setOnClickListener {
            goToMealItemsView()
        }
    }

    private fun setMeal() {
        when (mealType) {
            Constants.BREAKFAST -> {
                binding.textMeal.text = resources.getString(R.string.breakfast)
            }
            Constants.LUNCH -> {
                binding.textMeal.text = resources.getString(R.string.lunch)
            }
            Constants.DINNER -> {
                binding.textMeal.text = resources.getString(R.string.dinner)
            }
        }
        healthySuggestionMeal = dataManager.getHealthyMeal(mealType)
        listMealItem = ArrayList(dataManager.getMeals(mealType))
        totalCaloriesPerMeal = dataManager.getMealCalories(mealType)
    }

    private fun setMealItems() {
        if (listMealItem.isNotEmpty()) {
            binding.animationEmptyList.visibility = View.GONE
            binding.noItems.visibility = View.GONE
            binding.textTotalCalories.visibility = View.VISIBLE
            binding.textTotalCaloriesAmount.visibility = View.VISIBLE
            binding.listMealItems.visibility = View.VISIBLE

            binding.textTotalCaloriesAmount.text = resources.getString(
                R.string.calories_number,
                totalCaloriesPerMeal.toString()
            )

            binding.listMealItems.layoutManager = GridLayoutManager(context, 1)
            mealAdapter = MealItemAdapter(listMealItem)
            binding.listMealItems.adapter = mealAdapter
        } else {
            binding.animationEmptyList.visibility = View.VISIBLE
            binding.noItems.visibility = View.VISIBLE
            binding.textTotalCalories.visibility = View.GONE
            binding.textTotalCaloriesAmount.visibility = View.GONE
            binding.listMealItems.visibility = View.INVISIBLE
        }
    }

    private fun goToMealItemsView() {
        val fragment = MealFragment()
        changeFragmentWithData(
            fragment,
            Constants.ADD_FRAGMENT,
            Bundle()
        )
    }

    override fun onClick(item: HealthyFood) {
        val fragment = DetailMealFragment()
        val data = Bundle()
        data.putParcelable(Constants.EXTRA_MEAL_DETAILS, item)
        fragment.arguments = data
        changeFragmentWithData(
            fragment,
            Constants.ADD_FRAGMENT,
            data
        )
    }

}