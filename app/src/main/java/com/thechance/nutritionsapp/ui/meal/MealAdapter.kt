package com.thechance.nutritionsapp.ui.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.MealItemLayoutBinding
import java.util.*
import kotlin.collections.ArrayList

class MealAdapter(
    private var nutritionList: ArrayList<NutritionItem>,
    private var listener: OnClickListener
) : RecyclerView.Adapter<MealAdapter.ConverterViewHolder>() {

    interface OnClickListener {
        fun onClick(item: NutritionItem)
        fun onDelete(item: NutritionItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.itemView.setOnClickListener{
            listener.onClick(nutritionItem)
        }

        holder.binding.apply {
            mealItem1Name.text = nutritionItem.name
            mealItem1Calories.text =
                holder.itemView.context.resources.getString(R.string.calories_tv).format(
                    Locale.US, nutritionItem.calories
                )
            btnDeleteItem1.setOnClickListener {
                listener.onDelete(nutritionItem)
            }
        }
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(val binding: MealItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
