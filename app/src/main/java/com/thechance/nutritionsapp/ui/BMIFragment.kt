package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentBMIBinding

class BMIFragment : BaseFragment<FragmentBMIBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBMIBinding =
        FragmentBMIBinding::inflate

    override fun setup() {
        this.setupActionBar(
            toolbar = binding.bmiToolbar.toolbar,
            title = resources.getString(R.string.bmi)
        )

    }


}