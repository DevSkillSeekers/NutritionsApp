package com.thechance.nutritionsapp.ui.search

import androidx.recyclerview.widget.DiffUtil
import com.thechance.nutritionsapp.data.domain.NutritionItem

class SearchDiffUtil
    (val oldListNutritionItems : List<NutritionItem> ,
     val newListNutritionItems : List<NutritionItem>)
     : DiffUtil.Callback() {
    override fun getOldListSize() = oldListNutritionItems.size

    override fun getNewListSize() = newListNutritionItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldListNutritionItems[oldItemPosition].id == newListNutritionItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

}