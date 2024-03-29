package com.thechance.nutritionsapp.ui.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.state.ToggleableState
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.ui.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.User
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentMealBinding
import com.thechance.nutritionsapp.ui.ItemDetailsFragment
import com.thechance.nutritionsapp.ui.search.SearchFragment
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.getUserSharedPreferences
import com.thechance.nutritionsapp.util.saveUserSharedPreferences

class MealFragment : BaseFragment<FragmentMealBinding>(), MealAdapter.OnClickListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    private lateinit var listMealItem: ArrayList<NutritionItem>
    private var mealAdapter: MealAdapter? = null

    override fun setup() {

        var title = ""
        when (mealType) {
            Constants.BREAKFAST -> {
                listMealItem = breakfast
                title = resources.getString(R.string.breakfast)
            }
            Constants.LUNCH -> {
                listMealItem = lunch
                title = resources.getString(R.string.lunch)
            }
            else -> {
                listMealItem = dinner
                title = resources.getString(R.string.dinner)
            }
        }

        setupActionBar(
            toolbar = binding.mealToolbar.toolbar,
            title = title
        )

        if (listMealItem.isNotEmpty()) {
            binding.emptyTv.visibility = View.GONE
            binding.animationEmptyMeal.visibility = View.GONE
            binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
            mealAdapter =
                MealAdapter(listMealItem, this)
            binding.mealRecyclerView.adapter = mealAdapter
        } else {
            binding.emptyTv.visibility = View.VISIBLE
            binding.animationEmptyMeal.visibility = View.VISIBLE
        }

        setListeners()
    }


    private fun setListeners() {
        binding.addToMealBtn.setOnClickListener {
            changeFragmentWithData(
                SearchFragment(),
                Constants.ADD_FRAGMENT,
                Bundle()
            )
        }
    }

    override fun onClick(item: NutritionItem) {
        val data = Bundle()
        data.putParcelable(Constants.EXTRA_NUTRITION_DETAILS, item)
         changeFragmentWithData(
            ItemDetailsFragment(),
            Constants.ADD_FRAGMENT,
            data
        )
    }

    override fun onDelete(item: NutritionItem) {
        val position = listMealItem.indexOf(item)
        listMealItem.remove(item)
        mealAdapter?.notifyItemRemoved(position)
    }

}