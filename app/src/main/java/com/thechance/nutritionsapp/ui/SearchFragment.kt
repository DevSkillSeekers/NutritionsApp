package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.RecyclerViewAdapter
import com.thechance.nutritionsapp.data.Meal
import com.thechance.nutritionsapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var arr : ArrayList<Meal> = ArrayList()
    private lateinit var search : SearchView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val customAdapter = RecyclerViewAdapter(arr)
        recyclerView = view.findViewById(R.id.mealRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = customAdapter
        search = view.findViewById(R.id.searchViewInput)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arr.add(Meal(R.drawable.ic_pizza,"Pizza","78 Cal",R.drawable.ic_outline_add_circle_24))
        //Here We Can Add Items To RecyclerView
       }
}