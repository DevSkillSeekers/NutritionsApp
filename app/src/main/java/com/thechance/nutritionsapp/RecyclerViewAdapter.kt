package com.thechance.nutritionsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.data.Meal

class RecyclerViewAdapter(private var arr : ArrayList<Meal>) : RecyclerView.Adapter<RecyclerViewAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.meal_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val meal: Meal = arr[position]
        holder.img.setImageResource(meal.img)
        holder.text.text = meal.name
        holder.cal.text = meal.cal
        holder.icon.setImageResource(meal.icon)
    }

    override fun getItemCount(): Int {
        return arr.size
    }


    class DataHolder(view: View): RecyclerView.ViewHolder(view){
        val img : ImageView = view.findViewById(R.id.imgMeal)
        val text : TextView = view.findViewById(R.id.tvTitle)
        val cal : TextView = view.findViewById(R.id.tvCal)
        val icon : ImageView = view.findViewById(R.id.addIcon)
    }
}