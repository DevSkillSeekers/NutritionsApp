package com.thechance.nutritionsapp.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.MealLayoutBinding
import com.thechance.nutritionsapp.ui.meal.MealAdapter
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.*
import kotlin.collections.ArrayList


class SearchAdapter(
    private var nutritionList: ArrayList<NutritionItem>,
    private var listener: OnClickListener
) : RecyclerView.Adapter<SearchAdapter.ConverterViewHolder>() {

    interface OnClickListener {
        fun onClick(item: NutritionItem)
    }

    fun setData(newItems: ArrayList<NutritionItem>) {
        val diffResult = DiffUtil.calculateDiff(SearchDiffUtil(nutritionList,newItems))
        nutritionList.clear()
        nutritionList.addAll(newItems)
        nutritionList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.itemView.setOnClickListener {
            listener.onClick(nutritionItem)
        }
        holder.binding.apply {
            titleTextView.text = nutritionItem.name
            proteinsTextView.text = holder.itemView.context.resources.getString(R.string.proteins_tv).format(Locale.US, nutritionItem.proteins)
            carbsTextView.text = holder.itemView.context.resources.getString(R.string.carbs_tv).format(Locale.US, nutritionItem.carbs)
            fatsTextView.text = holder.itemView.context.resources.getString(R.string.fats_tv).format(Locale.US, nutritionItem.fats)

        }
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(val binding: MealLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}