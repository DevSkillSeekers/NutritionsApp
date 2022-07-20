package com.thechance.nutritionsapp.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding
import com.thechance.nutritionsapp.ui.BaseFragment
import com.thechance.nutritionsapp.data.domain.NutritionItem
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
            ArrayList()
        } else {
            binding.emptySearch.visibility = View.GONE
            ArrayList(dataManager.getSpecificNutrition(keyword.toString()))
        }
        searchAdapter = SearchAdapter(nutritionList, this)
        binding.mealRecyclerView.adapter = searchAdapter
        setListeners()
    }

    private fun setListeners() {
        binding.edtTxtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(keyword: Editable?) {
                binding.emptySearch.visibility = View.GONE
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
        when (mealType) {
            Constants.BREAKFAST -> {
                breakfast.add(item)
            }
            Constants.LUNCH -> {
                lunch.add(item)
            }
            Constants.DINNER -> {
                dinner.add(item)
            }
        }
        val fragment = HomeFragment()
        val data = Bundle()
        data.putInt(Constants.EXTRA_Add_MEAL, mealType)
        fragment.arguments = data
        changeFragmentWithData(
            fragment,
            Constants.REPLACE_FRAGMENT,
            data
        )
    }

    override fun getData() {
        TODO("Not yet implemented")
    }

    override fun addDataToBundle() {
        TODO("Not yet implemented")
    }

}