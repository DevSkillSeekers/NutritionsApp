package com.thechance.nutritionsapp.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.ui.HomeActivity
import com.thechance.nutritionsapp.ui.HomeFragment
import com.thechance.nutritionsapp.ui.meal.MealFragment
import com.thechance.nutritionsapp.util.Constants


class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private var keyword: String? = null
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    private lateinit var dataManager: DataManager
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var nutritionList: ArrayList<NutritionItem>
    private var mealType = -1

    override fun setup() {
        dataManager = DataManager(requireContext())
        binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)

        mealType = arguments?.getInt(Constants.EXTRA_MEAL_TYPE) ?: -1

        nutritionList = if (keyword == null) {
            ArrayList()
        } else {
            ArrayList(dataManager.getSpecificNutrition(keyword.toString()))
        }
        searchAdapter = SearchAdapter(binding.mealRecyclerView.context, nutritionList)
        binding.mealRecyclerView.adapter = searchAdapter
        setListeners()
    }

    private fun setListeners() {
        searchAdapter.setOnItemClickListener { mealItem ->
            addToMeal(mealItem)
        }
        binding.edtTxtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(keyword: Editable?) {
                searchAdapter.setData(ArrayList(dataManager.getSpecificNutrition(keyword.toString())))
            }

            override fun beforeTextChanged(
                keyword: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                keyword: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
            }
        })
    }

    private fun addToMeal(item: NutritionItem) {
        val fragment = HomeFragment()
        if (mealType != -1) {
            val data = Bundle()
            data.putParcelable(Constants.MEAL_ITEMS_DATA, item)
            data.putInt(Constants.EXTRA_Add_MEAL, mealType)
            fragment.arguments = data
        }
        changeFragment(
            requireActivity() as HomeActivity,
            fragment,
            Constants.REPLACE_FRAGMENT
        )
    }
}