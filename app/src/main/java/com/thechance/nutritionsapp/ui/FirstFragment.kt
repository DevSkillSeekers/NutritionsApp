package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.databinding.FragmentFirstBinding
import com.thechance.nutritionsapp.datasource.CSVDataSource


class FirstFragment() : BaseFragment<FragmentFirstBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstBinding =
        FragmentFirstBinding::inflate

    override fun setup() {
        val dataSource = context?.let { CSVDataSource(it) }
        val data = dataSource?.getAllApps()
        if (data != null) {
            binding.ivText.text = data.take(10).toString()
        }
    }



}