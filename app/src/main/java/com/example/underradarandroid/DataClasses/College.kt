package com.example.underradarandroid.DataClasses

data class College(
    val id: String = "",
    val name: String = "",
    val mascot: String = "",
    val city: String = "",
    val state: String = "",
    var image: String? = null,
    var conference: String? = null,
    var conferenceId: String? = null,
    var division: String? = null,
    var description: String? = null,
    var logo: String? = null,
    var website: String? = null,
)
