package com.thechance.nutritionsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.DataManger
import com.thechance.nutritionsapp.databinding.FragmentHomeBinding
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding


class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun setup() {
        binding.searchTx.text = "Hello Search!1"
    }

}