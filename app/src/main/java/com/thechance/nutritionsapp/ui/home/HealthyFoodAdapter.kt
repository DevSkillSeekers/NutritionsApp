package com.thechance.nutritionsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.data.domain.HealthyFood
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.HealthyFoodBinding
import com.thechance.nutritionsapp.ui.search.SearchAdapter

class HealthyFoodAdapter(
    private var healthyFoodList: List<HealthyFood>,
    private var listener: OnClickListener
) : RecyclerView.Adapter<HealthyFoodAdapter.ConverterViewHolder>() {

    interface OnClickListener {
        fun onClick(item: HealthyFood)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(HealthyFoodBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val healthyFoodItem = healthyFoodList[position]
        holder.itemView.setOnClickListener{
            listener.onClick(healthyFoodItem)
        }
        holder.binding.apply {
            textHealthyFood.text = healthyFoodItem.name
//            imageHealthyFood.drawable = holder.itemView.resources.
        }
    }

    override fun getItemCount(): Int = healthyFoodList.size

    inner class ConverterViewHolder(val binding: HealthyFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}