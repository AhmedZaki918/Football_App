package com.example.footballapp.util

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.View.*
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


fun Context.toast(message: String?){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Context.toast(message:Int?){
    Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
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
        failure.isNetworkError -> toast(getString(R.string.connection_error))
        failure.errorCode == 404 -> toast(getString(R.string.not_found))
        failure.errorCode == 422 -> toast(getString(R.string.invalid_auth))
        else -> toast(getString(R.string.not_found))
    }
}