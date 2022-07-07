package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thechance.nutritionsapp.databinding.FragmentFirstBinding


class FirstFragment() : BaseFragment<FragmentFirstBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstBinding = FragmentFirstBinding::inflate

    override fun setup() {

    }


}