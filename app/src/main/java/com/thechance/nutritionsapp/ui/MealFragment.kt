package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.databinding.FragmentMealBinding

class MealFragment : BaseFragment<FragmentMealBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    override fun setup() {
    }

}