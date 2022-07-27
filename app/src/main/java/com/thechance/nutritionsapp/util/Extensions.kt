package com.thechance.nutritionsapp.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.thechance.nutritionsapp.R
import com.thechance.nutritionsapp.data.User
import com.thechance.nutritionsapp.ui.LoginFragment

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.getUserSharedPreferences(): User {
    val sharedPreferences =
        this.getSharedPreferences(Constants.TABLE_NAME, Context.MODE_PRIVATE)
    val name = sharedPreferences.getString(Constants.USER_NAME, this.getString(R.id.name_text))
    val age =  sharedPreferences.getInt(Constants.USER_AGE, this.getString(R.id.age_text).toInt())
    val height =  sharedPreferences.getFloat(Constants.USER_HEIGHT, this.getString(R.id.height_text).toFloat())
    val weight =  sharedPreferences.getFloat(Constants.USER_WEIGHT, this.getString(R.id.weight_text).toFloat())
    return User(userName = name, age = age, height =height.toDouble() , weight = weight.toDouble())
}

fun Context.saveUserSharedPreferences(user: User) {
    val sharedPreferences =
        this.getSharedPreferences(Constants.TABLE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(Constants.USER_NAME, user.userName)
    editor.putFloat(Constants.USER_WEIGHT, user.weight.toFloat())
    editor.putFloat(Constants.USER_HEIGHT, user.height.toFloat())
    editor.putInt(Constants.USER_AGE, user.age)
    editor.apply()
}