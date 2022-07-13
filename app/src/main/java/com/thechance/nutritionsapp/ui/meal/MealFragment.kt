package com.thechance.nutritionsapp.ui.meal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentMealBinding
import com.thechance.nutritionsapp.ui.HomeActivity
import com.thechance.nutritionsapp.ui.search.SearchFragment
import com.thechance.nutritionsapp.util.Constants

class MealFragment : BaseFragment<FragmentMealBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    private lateinit var listMealItem: ArrayList<NutritionItem>

    override fun setup() {
        this.setupActionBar(
            toolbar = binding.mealToolbar.toolbar,
            title = getString(R.string.breakfast)
        )
        listMealItem = arguments?.getParcelableArrayList(Constants.MEAL_ITEMS_DATA)!!
        if (listMealItem != null && listMealItem.isNotEmpty()) {
            binding.emptyTv.visibility = View.GONE
            binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
            val mealAdapter =
                MealAdapter(binding.mealRecyclerView.context, listMealItem)
            binding.mealRecyclerView.adapter = mealAdapter
        } else {
            binding.emptyTv.visibility = View.VISIBLE
        }
        setListeners()
    }

    private fun setListeners() {
        binding.addToMealBtn.setOnClickListener {
            changeFragment(
                requireActivity() as HomeActivity,
                SearchFragment(),
                Constants.ADD_FRAGMENT
            )
        }
    }
}