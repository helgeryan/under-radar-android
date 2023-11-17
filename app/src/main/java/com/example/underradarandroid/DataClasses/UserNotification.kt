package com.example.underradarandroid.DataClasses

import android.media.Image
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.ImageHelper

enum class UserNotifactionType(int: Int) {
    General(0),
    ProfileViewed(1),
    ProfileSaved(2),
    ProfileShared(3)
}

data class UserNotification(
    val id: String = "",
    val userId: String = "",
    val text: String = "",
    @field:JvmField var isRead: Boolean = false,
    var date: String = "",
    val type: Int = 0,
    var otherUserId: String? = null
) {
    fun getIcon(): Int {
        val notificationType = UserNotifactionType.values().firstOrNull() { it.ordinal == type }

        notificationType?.let {
            return when (notificationType) {
                UserNotifactionType.General -> ImageHelper.notification
                UserNotifactionType.ProfileViewed -> ImageHelper.view
                UserNotifactionType.ProfileShared -> ImageHelper.share
                UserNotifactionType.ProfileSaved -> ImageHelper.save
            }
        }

        return ImageHelper.notification
    }
//    var icon: String {
//        let type = UserNotificationType(rawValue: type) ?? UserNotificationType.general
//        return type.icon
//    }
//
//    var fsDate: Date {
//        return UnderRadarDateFormatter.dbFormatter.date(from: date) ?? Date()
//    }
}

//enum UserNotificationType: Int, CaseIterable {
//    case general = 0
//    case profileViewed
//    case profileSaved
//    case profileShared
//

//}
//}