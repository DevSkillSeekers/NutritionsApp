package com.thechance.nutritionsapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R


class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun setup() {
        this.setupActionBar(
            toolbar = binding.searchToolbar.toolbar,
            title = resources.getString(R.string.search)
        )

//        binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
//        val customAdapter =
//            SearchAdapter(binding.mealRecyclerView.context, DataManager.getNutrition(10))
//        binding.mealRecyclerView.adapter = customAdapter

    }


}