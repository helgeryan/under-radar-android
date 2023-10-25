package com.example.underradarandroid.DataClasses

import java.io.Serializable

data class User (
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    var phone: String? = null,
    var profileType: Int = 0,
    var profilePicUrl: String? = null,
    var jobTitle: String? = null,
    var hometown: String? = null,
    var momFullName: String? = null,
    var dadFullName: String? = null,
    var school: String? = null,
    var college: String? = null,
    var state: String? = null,
    var year: Int? = null,
    var height: Int? = null,
    var weight: Int? = null,
    var armside: String? = null,
    var batside: String? = null,
//    var positions: Array<String>? = nil,
    var twitterHandle: String? = null,
    var collegeCommit: String? = null,
    var gpa: Double? = null,
    var club: String? = null,
    var videos: List<Video>? = null,
//    var links: [UserLink]?,
    var scoutInfo: ScoutInfo? = null,
    var yearsOfEligibility: Int? = null,
    var currentCollegeId: String? = null,
    var summerTeam: String? = null
): Serializable {
    fun getHometownText(): String {
        return "$hometown, $state"
    }

    fun isPlayer(): Boolean {
        return when(profileType) {
            0,1 -> true
            else -> false
        }
    }
    fun isCoach(): Boolean {
        return when(profileType) {
            0,1 -> false
            else -> true
        }
    }
}


data class Video (
    val id: String = "",
    val caption: String = "",
    val thumbnail: String = "",
    val date: String = "",
    val videoUrl: String = "",
): Serializable

data class ScoutInfo (
    val verifiedBy: String = "",
    val fastball: String = "",
    val curveball: String = "",
    val sixty: String = "",
    val ofVelo: String = "",
    val ifVelo: String = "",
    val slider: String = "",
    val popTime: String = "",
    val exitVelo: String = "",
    val workoutDescription: String = "",
): Serializable