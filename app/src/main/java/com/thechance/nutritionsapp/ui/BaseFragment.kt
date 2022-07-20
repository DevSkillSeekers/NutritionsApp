package com.thechance.nutritionsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.DataManager
import com.thechance.nutritionsapp.data.domain.NutritionItem
import com.thechance.nutritionsapp.ui.home.HomeFragment
import com.thechance.nutritionsapp.util.Constants

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected lateinit var dataManager: DataManager
    protected lateinit var breakfast: ArrayList<NutritionItem>
    protected lateinit var lunch: ArrayList<NutritionItem>
    protected lateinit var dinner: ArrayList<NutritionItem>
    protected var mealType = Constants.BREAKFAST

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)

        dataManager = DataManager()
        mealType = arguments?.getInt(Constants.EXTRA_MEAL_TYPE) ?: Constants.BREAKFAST
        breakfast = arguments?.getParcelableArrayList(Constants.EXTRA_BREAKFAST) ?: arrayListOf()
        lunch = arguments?.getParcelableArrayList(Constants.EXTRA_LUNCH) ?: arrayListOf()
        dinner = arguments?.getParcelableArrayList(Constants.EXTRA_DINNER) ?: arrayListOf()

        dataManager.addBreakfast(breakfast)
        dataManager.addDinner(dinner)
        dataManager.addLunch(lunch)

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    changeFragmentWithData(
                        HomeFragment(),
                        Constants.REPLACE_FRAGMENT,
                        Bundle()
                    )
                }
            })

        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    abstract fun setup()

    abstract fun getData()

    abstract fun addDataToBundle()

    fun changeFragmentWithData(
        fragment: Fragment,
        type: Int,
        data: Bundle
    ) {
        val manager: FragmentManager = parentFragmentManager
        val transaction =
            manager.beginTransaction()
        data.putInt(Constants.EXTRA_MEAL_TYPE, mealType)
        data.putParcelableArrayList(Constants.EXTRA_BREAKFAST, breakfast)
        data.putParcelableArrayList(Constants.EXTRA_LUNCH, lunch)
        data.putParcelableArrayList(Constants.EXTRA_DINNER, dinner)
        fragment.arguments = data

        when (type) {
            Constants.ADD_FRAGMENT -> {
                transaction.add(R.id.nav_host_fragment, fragment)
            }
            Constants.REPLACE_FRAGMENT -> {
                transaction.replace(R.id.nav_host_fragment, fragment)
            }
        }
        transaction.commit()
    }

    fun setupActionBar(toolbar: Toolbar, title: String) {
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        val actionBar = (activity as AppCompatActivity?)!!.supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = title
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        toolbar.setNavigationOnClickListener {
            changeFragmentWithData(
                HomeFragment(), Constants.REPLACE_FRAGMENT, Bundle()
            )
        }
    }
}