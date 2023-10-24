package com.example.underradarandroid.DataClasses

import java.io.Serializable

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
    var website: String? = null
): Serializable {
    fun getCollegeName(): String {
        return this.name + " " + this.mascot
    }

    fun getLocation(): String {
        return this.city + ", " + this.state
    }
}
