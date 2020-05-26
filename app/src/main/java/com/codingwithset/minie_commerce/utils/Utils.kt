package com.codingwithset.minie_commerce.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.codingwithset.minie_commerce.R
import java.lang.Exception


/*
this function [callSeller] call the merchant
 */
fun View.callSeller() {
    val phone: String = context.getString(R.string.seller_number_developer)
    val intent =
        Intent(Intent.ACTION_DIAL, Uri.fromParts(context.getString(R.string.tel), phone, null))
    context.startActivity(intent)
}

/*
set the view visibility to be visible
 */
fun View.visible() {
    this.visibility = View.VISIBLE

}

/*
set the view visibility to be gone
 */
fun View.gone() {
    this.visibility = View.GONE

}

/**
 * Check whether network is available by ping ip/domain name
 * @return Whether device is connected to Network.
 */
fun checkInternetAccess():Boolean{
    try {
        val process: Process = Runtime.getRuntime().exec("ping -c 1 8.8.8.8")
        val returnVal = process.waitFor()
        return (returnVal == 0)
    }catch (exception: Exception){
        exception.printStackTrace()
    }
   return false

}

/*
hide the keyboard
 */
fun Activity.hideKeyboard() {
    val inputMethodManager: InputMethodManager? =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
}



