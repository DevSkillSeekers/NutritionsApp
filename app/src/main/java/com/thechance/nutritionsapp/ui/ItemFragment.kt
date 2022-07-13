package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentItemDetailsBinding

class ItemFragment: BaseFragment<FragmentItemDetailsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentItemDetailsBinding
         get() = TODO("Not yet implemented")

    override fun setup() {
        TODO("Not yet implemented")
        val items = listOf("kg","g","mg","lb")
        val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,items)
        binding.autoCompleteTextView.setAdapter(adapter)

    }
}