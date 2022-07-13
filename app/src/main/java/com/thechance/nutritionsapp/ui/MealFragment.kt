package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.DataManger
import com.thechance.nutritionsapp.databinding.FragmentMealBinding
import com.thechance.nutritionsapp.ui.search.SearchFragment

class MealFragment : BaseFragment<FragmentMealBinding>() {
    private val activityHome=HomeActivity()
    private val fragmentSearch = SearchFragment()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    override fun setup() {
        //TODO("Not yet implemented")
    }

       fun deleteItem(v: View) {
           if(v.id ==R.id.btnDeleteItem1){
               binding.mealItem1Box.visibility=View.GONE
               val i2params=binding.mealItem2Box.layoutParams as ConstraintLayout.LayoutParams
               val i3params=binding.mealItem3Box.layoutParams as ConstraintLayout.LayoutParams
               i2params.topToTop=binding.mealItem1Box.id
               i3params.topToTop=binding.mealItem2Box.id
           }

           else if(v.id ==R.id.btnDeleteItem2){
               binding.mealItem2Box.visibility=View.GONE
               val i3params=binding.mealItem3Box.layoutParams as ConstraintLayout.LayoutParams
               i3params.topToTop=binding.mealItem2Box.id
           }

           else if(v.id ==R.id.btnDeleteItem2){
               binding.mealItem3Box.visibility=View.GONE
           }

       }

    
    fun backToHome(v: View){
//        val transaction=supportFragmentManager.beginTransaction()
//        transaction.remove(R.id.fragment_meal, MealFragment).commit()
    }

    fun goToSearch(v: View){
//        val transaction=supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_search, fragmentSearch).commit()
    }

}