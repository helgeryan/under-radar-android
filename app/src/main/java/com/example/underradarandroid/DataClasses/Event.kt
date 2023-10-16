package com.example.underradarandroid.DataClasses

data class Event(
    val id : String = "",
    val title: String = "",
    val description: String = "",
    val text: String = "",
    val address: String? = null,
    val state: String = "",
    val publishedDate: String = "",
    val startDate: String = "",
    val endDate: String = "",
    val authorId: String = "",
    var additionalLink: String? = null,
    var headerImage: String? = null,
    var club: String? = null,
    var college: String? = null,
    val isPublished: Boolean = false,
    val isPendingReview: Boolean = true
)
