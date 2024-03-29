package com.example.footballapp.util

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast
import com.example.footballapp.R
import com.example.footballapp.data.network.Resource

fun <T> Context.startActivity(cls: Class<T>, key: String = "", value: Any = "") {
    if (key != "" && value != "") {
        Intent(this, cls).apply {
            when (value) {
                is String -> putExtra(key, value)
                is Int -> putExtra(key, value)
                is Boolean -> putExtra(key, value)
                is Parcelable -> putExtra(key, value)
            }
            startActivity(this)
        }
    } else {
        Intent(this, cls).apply {
            startActivity(this)
        }
    }
}


fun Context.toast(message: String?,duration: Int){
    Toast.makeText(this, message, duration).show()
}
fun Context.toast(message:Int?, duration: Int){
    Toast.makeText(this, message.toString(), duration).show()
}


fun ProgressBar.hide() {
    visibility = GONE
}
fun ProgressBar.show() {
    visibility = VISIBLE
}


fun Context.handleApiError(
    failure: Resource.Failure
) {
    when {
        failure.isNetworkError -> toast(getString(R.string.connection_error),Toast.LENGTH_SHORT)
        failure.errorCode == 404 -> toast(getString(R.string.not_found),Toast.LENGTH_SHORT)
        failure.errorCode == 422 -> toast(getString(R.string.invalid_auth),Toast.LENGTH_SHORT)
        else -> toast(getString(R.string.not_found),Toast.LENGTH_SHORT)
    }
}