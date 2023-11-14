package com.example.underradarandroid.DataClasses

import java.io.Serializable

data class Bookmark (
    val id: String = "",
    val bookmarkUserId: String = "",
    val userId: String = ""
): Serializable