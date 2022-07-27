package com.thechance.nutritionsapp.ui.search

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.DietValues
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding
import com.thechance.nutritionsapp.ui.BaseFragment
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.ui.ItemDetailsFragment
import com.thechance.nutritionsapp.ui.home.HomeFragment
import com.thechance.nutritionsapp.util.Constants
import com.thechance.nutritionsapp.util.hideKeyboard


class SearchFragment : BaseFragment<FragmentSearchBinding>(), SearchAdapter.OnClickListener {
    private var keyword: String? = null
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var nutritionList: ArrayList<NutritionItem>

    override fun setup() {
        binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
        nutritionList = if (keyword == null) {
            binding.emptySearch.visibility = View.VISIBLE
            binding.animationEmptySearch.visibility = View.VISIBLE
            ArrayList()
        } else {
            binding.emptySearch.visibility = View.GONE
            binding.animationEmptySearch.visibility = View.GONE
            ArrayList(dataManager.getSpecificNutrition(keyword.toString()))
        }
        searchAdapter = SearchAdapter(nutritionList, this)
        binding.mealRecyclerView.adapter = searchAdapter
        setListeners()
    }

    private fun setListeners() {
        binding.searchViewInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(keyword: Editable?) {
                binding.emptySearch.visibility = View.GONE
                binding.animationEmptySearch.visibility = View.GONE
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

    override fun onClick(item: NutritionItem) {
        this.hideKeyboard()
        val fragment = ItemDetailsFragment()
        val data = Bundle()
        data.putInt(Constants.EXTRA_Add_MEAL, mealType)
        data.putParcelable(Constants.EXTRA_NUTRITION_DETAILS,item)
        fragment.arguments = data
        changeFragmentWithData(
            fragment,
            Constants.ADD_FRAGMENT,
            data
        )
    }
}