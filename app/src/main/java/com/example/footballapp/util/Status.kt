package com.example.footballapp.util

enum class Status(val status: String) {
    IN_PLAY("IN_PLAY"),
    LIVE("LIVE"),
    CANCELLED("CANCELLED"),
    FINISHED("FINISHED"),
    TIMED("TIMED"),
    PAUSED("PAUSED")
}