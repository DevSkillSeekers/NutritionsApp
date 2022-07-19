package com.thechance.nutritionsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBlankBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener{

        }
        return binding.root
    }

}

