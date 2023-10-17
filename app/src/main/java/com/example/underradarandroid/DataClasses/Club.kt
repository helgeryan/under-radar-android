package com.example.underradarandroid.DataClasses

data class Club (
    val id: String = "",
    val name: String = "",
    val city: String = "",
    val state: String = "",
    var bio: String? = null,
    var address: String? = null,
    var adminId: String? = null,
    var logo: String? = null,
    var description: String? = null,
    var website: String? = null,
    var isVerified: Boolean? = false
) {
    fun getLocation(): String {
        return this.city + ", " + this.state
    }
}
