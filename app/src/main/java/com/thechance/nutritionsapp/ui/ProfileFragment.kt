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
import com.thechance.nutritionsapp.data.User
import com.thechance.nutritionsapp.data.domain.DietValues
import com.thechance.nutritionsapp.databinding.ActivityHomeBinding
import com.thechance.nutritionsapp.databinding.FragmentProfileBinding
import com.thechance.nutritionsapp.util.getUserSharedPreferences
import com.thechance.nutritionsapp.util.saveUserSharedPreferences


class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding =
        FragmentProfileBinding::inflate
    private lateinit var user: User
    override fun setup() {
        setupActionBar(
            toolbar = binding.ProfileToolbar.toolbar,
            title = resources.getString(R.string.profile)
        )
        setData()
        setListeners()
    }

    private fun setData() {
        user = requireContext().getUserSharedPreferences()
        binding.textUserName.text = user.userName
        binding.textUserAge.text = user.age.toString()
        binding.textUserHeight.text = user.height.toString()
        binding.textUserWight.text = user.weight.toString()
    }

    private var msg = ""
    private fun setListeners() {
        binding.btnEditProfile.setOnClickListener() {
            binding.cardProfileEdit.visibility = View.VISIBLE
            binding.cardProfileInfo.setBackgroundColor(Color.argb(40, 0, 0, 0))
        }
        binding.btnUpdateEdit.setOnClickListener() {
            if ((binding.textEditUserName.toString() == "") || (binding.textEditUserAge.text.toString() == "") || (binding.textEditUserHeight.text.toString() == "") || (binding.textEditUserWight.text.toString() == "")) {
                msg = "Oops, there's empty field!\nPlease check out your inputs again."
                Snackbar.make(binding.root, "${msg}", Snackbar.LENGTH_LONG).show()
            } else {
                user.userName = binding.textEditUserName.text.toString()
                user.age = binding.textEditUserAge.text.toString().toInt()
                user.height = binding.textEditUserHeight.text.toString().toDouble()
                user.weight = binding.textEditUserWight.text.toString().toDouble()
                requireContext().saveUserSharedPreferences(user)
                binding.cardProfileEdit.visibility = View.GONE
                binding.cardProfileInfo.setBackgroundColor(Color.TRANSPARENT)
                setData()
            }
        }

        binding.btnCancelEdit.setOnClickListener() {
            binding.cardProfileEdit.visibility = View.GONE
            binding.cardProfileInfo.setBackgroundColor(Color.TRANSPARENT)
        }

    }

}