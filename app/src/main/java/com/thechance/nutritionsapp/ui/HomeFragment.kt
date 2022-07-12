package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.data.DataManger
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        binding.ivText.text = DataManger.getBreakfast().toString()
    }


}