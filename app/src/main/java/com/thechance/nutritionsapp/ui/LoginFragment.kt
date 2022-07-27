package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.databinding.FragmentDietTypeBinding
import com.thechance.nutritionsapp.databinding.FragmentLoginBinding
import com.thechance.nutritionsapp.ui.home.HomeFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding =
        FragmentLoginBinding::inflate

    override fun setup() {
        val navBar: BottomNavigationView = activity!!.findViewById(R.id.bottom_nav)
        navBar.visibility = View.GONE
        binding.loginBtn.setOnClickListener {
            if(validateUserName() && validateAge() && validateHeight() && validateWeight()){
                changeFragment(HomeFragment())
                navBar.visibility = View.VISIBLE
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }

    private fun validateUserName(): Boolean{
        val pattern = Regex("[a-zA-Z]+")
        return if(binding.nameText.text.isNullOrBlank()
            || !binding.nameText.text.toString().matches(pattern)) {
            binding.userName.error = getString(R.string.name_error)
            false
        }else{
            binding.userName.error = null
            true
        }
    }

    private fun validateAge(): Boolean{
        return if(binding.ageText.text.toString().isNullOrBlank()
            || binding.ageText.text.toString().toInt() !in 16..110){
            binding.age.error = getString(R.string.age_error)
            false
        }else{
            binding.age.error = null
            true
        }
    }

    private fun validateHeight(): Boolean{
        return if(binding.heightText.text.toString().isNullOrBlank()
            || binding.heightText.text.toString().toInt() !in 140..210){
            binding.height.error = getString(R.string.height_error)
            false
        }else{
            binding.height.error = null
            true
        }
    }

    private fun validateWeight(): Boolean{
        return if(binding.weightText.text.toString().isNullOrBlank()
            || binding.weightText.text.toString().toInt() !in 40..132){
            binding.weight.error = getString(R.string.weight_error)
            false
        }else{
            binding.weight.error = null
            true
        }
    }
}