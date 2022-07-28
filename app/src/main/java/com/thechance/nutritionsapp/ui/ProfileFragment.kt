package com.thechance.nutritionsapp.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.snackbar.Snackbar
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.DietValues
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import com.thechance.nutritionsapp.databinding.FragmentProfileBinding


class ProfileFragment: BaseFragment<FragmentProfileBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding =
        FragmentProfileBinding::inflate

    override fun setup() {
        setupActionBar(
            toolbar = binding.ProfileToolbar.toolbar,
            title = "Profile"
        )
        setListeners()

    }

    private var msg=""
    private fun setListeners(){
        binding.btnEditProfile.setOnClickListener(){
            binding.cardProfileEdit.visibility= View.VISIBLE
            binding.cardProfileInfo.setBackgroundColor(Color.argb(40,0,0,0))
        }
        binding.btnUpdateEdit.setOnClickListener(){
            if((binding.textEditUserName.toString() == "") || (binding.textEditUserAge.text.toString() == "") || (binding.textEditUserHeight.text.toString() == "") || (binding.textEditUserWight.text.toString() == "")){
                msg = "Oops, there's empty field!\nPlease check out your inputs again."
                Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
            }
            else {
                binding.textUserName.text = binding.textEditUserName.text
                binding.textUserAge.text = binding.textEditUserAge.text.toString()
                binding.textUserHeight.text = binding.textEditUserHeight.text.toString()
                binding.textUserWight.text = binding.textEditUserWight.text.toString()
                binding.cardProfileEdit.visibility = View.GONE
                binding.cardProfileInfo.setBackgroundColor(Color.TRANSPARENT)
            }
        }

        binding.btnCancelEdit.setOnClickListener(){
            binding.cardProfileEdit.visibility= View.GONE
            binding.cardProfileInfo.setBackgroundColor(Color.TRANSPARENT)
        }

    }

}