package com.thechance.nutritionsapp.ui.search

import android.R.attr.data
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.MealLayoutBinding
import java.util.*
import kotlin.collections.ArrayList


class SearchAdapter(
    private val context: Context,
    private var nutritionList: ArrayList<NutritionItem>
) : RecyclerView.Adapter<SearchAdapter.ConverterViewHolder>() {

    private var listener: ((nutritionItem: NutritionItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (nutritionItem: NutritionItem) -> Unit) {
        this.listener = listener
    }

    fun setData(newItems: ArrayList<NutritionItem>) {
        nutritionList.clear()
        nutritionList.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.binding.apply {
            tvTitle.text = nutritionItem.name
            tvCal.text = context.resources.getString(R.string.calories_tv).format(
                Locale.US, nutritionItem.calories
            )
            addIcon.setOnClickListener {
                listener?.invoke(nutritionItem)
            }

        }
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(val binding: MealLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}