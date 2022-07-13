package com.thechance.nutritionsapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding
import com.thechance.nutritionsapp.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun setup() {
        /*binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
        val customAdapter =
            SearchAdapter(binding.mealRecyclerView.context, DataManager.getNutrition(10))
        binding.mealRecyclerView.adapter = customAdapter*/

        /* binding.mealRecyclerView.setHasFixedSize(true)
         val layoutManager = LinearLayoutManager(context)
         layoutManager.orientation = RecyclerView.VERTICAL
         binding.mealRecyclerView.layoutManager = layoutManager*/
    }


}