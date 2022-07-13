package com.thechance.nutritionsapp.ui.meal

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.databinding.MealItemLayoutBinding
import com.thechance.nutritionsapp.util.Constants
import java.util.*
import kotlin.collections.ArrayList

class MealAdapter(
    private val context: Context,
    private var nutritionList: ArrayList<NutritionItem>
) :
    RecyclerView.Adapter<MealAdapter.ConverterViewHolder>() {

    private var listener: ((nutritionItem: NutritionItem, actionType: Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (nutritionItem: NutritionItem, actionType: Int) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConverterViewHolder {
        return ConverterViewHolder(MealItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConverterViewHolder, position: Int) {
        val nutritionItem = nutritionList[position]
        holder.itemView.setOnClickListener {
            listener?.invoke(nutritionItem, Constants.ACTION_OPEN)
        }
        holder.binding.apply {
            mealItem1Name.text = nutritionItem.name
            mealItem1Calories.text =
                context.resources.getString(R.string.calories_tv).format(
                    Locale.US, nutritionItem.calories
                )
            btnDeleteItem1.setOnClickListener {
                listener?.invoke(
                    nutritionItem,
                    Constants.ACTION_DELETE
                )
            }
        }
    }


    override fun getItemCount(): Int = nutritionList.size

    inner class ConverterViewHolder(val binding: MealItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}