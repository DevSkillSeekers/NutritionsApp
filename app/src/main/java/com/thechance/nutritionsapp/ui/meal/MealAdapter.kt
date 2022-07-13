package com.thechance.nutritionsapp.ui.meal

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.MealItemLayoutBinding
import java.util.*
import kotlin.collections.ArrayList

class MealAdapter(
    private val context: Context,
    private var nutritionList: ArrayList<NutritionItem>
) :
    RecyclerView.Adapter<MealAdapter.ConverterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.setData(nutritionItem)
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(private val binding: MealItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(item: NutritionItem) {
            binding.mealItem1Name.text = item.name
            binding.mealItem1Calories.text =
                context.resources.getString(R.string.calories_tv).format(
                    Locale.US, item.calories
                )
        }
    }
}