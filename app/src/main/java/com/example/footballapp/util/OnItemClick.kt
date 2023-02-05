package com.example.footballapp.util

interface OnItemClick {
    fun <T> onClicked(model: T)
}