package com.thechance.nutritionsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R


class RecyclerAdapter(
    private var hashmap: HashMap<String, String>
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView
        val itemAmount: TextView

        init {
            itemTitle = itemView.findViewById(R.id.text_nutrition_name)
            itemAmount = itemView.findViewById(R.id.nutrition_amount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.nutrition_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return hashmap.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = hashmap.keys.toList()[position]
        holder.itemAmount.text = hashmap.values.toList()[position]

    }
}
