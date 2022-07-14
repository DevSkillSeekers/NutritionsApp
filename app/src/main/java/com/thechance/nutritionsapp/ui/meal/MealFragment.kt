package com.thechance.nutritionsapp.ui.meal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentMealBinding
import com.thechance.nutritionsapp.ui.DetailMealFragment
import com.thechance.nutritionsapp.ui.HomeActivity
import com.thechance.nutritionsapp.ui.ItemDetailsFragment
import com.thechance.nutritionsapp.ui.search.SearchFragment
import com.thechance.nutritionsapp.util.Constants

class MealFragment : BaseFragment<FragmentMealBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    private lateinit var listMealItem: ArrayList<NutritionItem>
    private lateinit var mealAdapter: MealAdapter

    override fun setup() {
        this.setupActionBar(
            toolbar = binding.mealToolbar.toolbar,
            title = getString(R.string.breakfast)
        )
        listMealItem = arguments?.getParcelableArrayList(Constants.MEAL_ITEMS_DATA)!!
        if (listMealItem != null && listMealItem.isNotEmpty()) {
            binding.emptyTv.visibility = View.GONE
            binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
            mealAdapter =
                MealAdapter(binding.mealRecyclerView.context, listMealItem)
            binding.mealRecyclerView.adapter = mealAdapter
        } else {
            binding.emptyTv.visibility = View.VISIBLE
        }
        setListeners()
    }

    private fun setListeners() {
        mealAdapter.setOnItemClickListener { item, actionType ->
            when (actionType) {
                Constants.ACTION_OPEN -> {
//                    val fragment = ItemDetailsFragment()
//                    val data = Bundle()
//                    data.putParcelable(Constants.EXTRA_NUTRITION_DETAILS, item)
//                    fragment.arguments = data
//                    changeFragment(
//                        requireActivity() as HomeActivity,
//                        fragment,
//                        Constants.ADD_FRAGMENT
//                    )
                }
                Constants.ACTION_DELETE -> {
                    val position = listMealItem.indexOf(item)
                    listMealItem.remove(item)
                    mealAdapter.notifyItemRemoved(position)
                }
            }
        }
        binding.addToMealBtn.setOnClickListener {
            changeFragment(
                requireActivity() as HomeActivity,
                SearchFragment(),
                Constants.ADD_FRAGMENT
            )
        }
    }
}