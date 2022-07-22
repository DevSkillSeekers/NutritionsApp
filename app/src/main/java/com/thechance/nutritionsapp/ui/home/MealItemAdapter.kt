package com.thechance.nutritionsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.ItemMealBinding
import java.util.*
import kotlin.collections.ArrayList

class MealItemAdapter(private var nutritionList: ArrayList<NutritionItem>)
: RecyclerView.Adapter<MealItemAdapter.ConverterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(ItemMealBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]

        holder.binding.apply {
            textMealName.text = nutritionItem.name
            textCalsAmount.text = nutritionItem.calories.toString()
            textAmount.text = nutritionItem.servingSize
        }
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(val binding: ItemMealBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}