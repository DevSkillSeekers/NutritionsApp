package com.thechance.nutritionsapp.ui.search

import android.R.attr.data
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
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

    //Need to review.
    fun setData(newItems: ArrayList<NutritionItem>) {
        val diffResult = DiffUtil.calculateDiff(SearchDiffUtil(nutritionList,newItems))
        nutritionList.clear()
        nutritionList.addAll(newItems)
        nutritionList = newItems
        diffResult.dispatchUpdatesTo(this)
       // notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.binding.apply {
            titleTextView.text = nutritionItem.name
            caloriesTextView.text =
                holder.itemView.context.resources.getString(R.string.calories_tv).format(
                    Locale.US, nutritionItem.calories
                )
            addIcon.setOnClickListener {
                listener.onClick(nutritionItem)
            }

        }
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(val binding: MealLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}