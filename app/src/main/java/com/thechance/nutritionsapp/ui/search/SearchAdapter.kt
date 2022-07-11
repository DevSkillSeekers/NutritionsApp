package com.thechance.nutritionsapp.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.res.stringResource
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.MealLayoutBinding
import java.util.*

class SearchAdapter(private val context: Context, private var nutritionList: List<NutritionItem>) :
    RecyclerView.Adapter<SearchAdapter.ConverterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.setData(nutritionItem)
    }

    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(private val binding: MealLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(item: NutritionItem) {
            binding.tvTitle.text = item.name
            binding.tvCal.text = context.resources.getString(R.string.calories_tv).format(
                Locale.US, item.calories
            )
        }
    }
}