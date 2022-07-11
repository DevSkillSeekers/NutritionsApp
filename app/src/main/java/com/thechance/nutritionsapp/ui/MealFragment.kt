package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding
import com.thechance.nutritionsapp.databinding.FragmentMealBinding

class MealFragment : BaseFragment<FragmentMealBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    override fun setup() {
        TODO("Not yet implemented")
    }

}