package com.example.underradarandroid.DataClasses

data class UserNotification(
    val id: String = "",
    val userId: String = "",
    val text: String = "",
    var isRead: Boolean = true,
    var date: String = "",
    val type: Int = 0,
    var otherUserId: String? = null
)
