package com.thechance.nutritionsapp.ui.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.compose.material3.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.thechance.nutritionsapp.BaseFragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.FragmentMealBinding
import com.thechance.nutritionsapp.ui.HomeActivity
import com.thechance.nutritionsapp.ui.search.SearchFragment
import com.thechance.nutritionsapp.util.Constants

class MealFragment : BaseFragment<FragmentMealBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMealBinding =
        FragmentMealBinding::inflate

    private lateinit var listMealItem: ArrayList<NutritionItem>
    private var mealAdapter: MealAdapter? = null

    override fun setup() {
        var title = ""
        when (mealType) {
            Constants.BREAKFAST -> {
                listMealItem = breakfast
                title = resources.getString(R.string.breakfast)
            }
            Constants.LUNCH -> {
                listMealItem = lunch
                title = resources.getString(R.string.lunch)
            }
            else -> {
                listMealItem = dinner
                title = resources.getString(R.string.dinner)
            }
        }

        this.setupActionBar(
            toolbar = binding.mealToolbar.toolbar,
            title = title
        )

        if (listMealItem.isNotEmpty()) {
            binding.emptyTv.visibility = View.GONE
            binding.mealRecyclerView.layoutManager = GridLayoutManager(context, 1)
            mealAdapter =
                MealAdapter(binding.mealRecyclerView.context, listMealItem)
            binding.mealRecyclerView.adapter = mealAdapter
        } else {
            binding.emptyTv.visibility = View.VISIBLE
        }
        setListeners()
    }

    private fun setListeners() {
        mealAdapter?.setOnItemClickListener { item, actionType ->
            when (actionType) {
                Constants.ACTION_OPEN -> {
                    Toast.makeText(context, "OPEN ${item.name}", Toast.LENGTH_LONG)
                        .show()
                }
                Constants.ACTION_DELETE -> {
                    val builder = AlertDialog.Builder(context)
                    builder.apply {
                        setTitle("Delete meal")
                        setMessage("Are you sure to delete \"${item.name}\" meal? ")
                        setPositiveButton("Yes",DialogInterface.OnClickListener{dialogInterface, i ->
                            val position = listMealItem.indexOf(item)
                            listMealItem.remove(item)
                            mealAdapter?.notifyItemRemoved(position)
                            Toast.makeText(context, "Meal \"${item.name}\" was deleted." , Toast.LENGTH_LONG).show()
                        })
                        setNegativeButton("No",DialogInterface.OnClickListener{dialogInterface, i ->  })
                    }
                    val dialog = builder.create()
                    dialog.show()
                }
            }
        }
        binding.addToMealBtn.setOnClickListener {
            changeFragmentWithData(
                requireActivity() as HomeActivity,
                SearchFragment(),
                Constants.ADD_FRAGMENT,
                Bundle()
            )
        }
    }
}