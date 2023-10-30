package com.example.underradarandroid.Resources.Extensions

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

class UnderRadarDateFormatter {
     @RequiresApi(Build.VERSION_CODES.O)
     val dbFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ssZ")

    @RequiresApi(Build.VERSION_CODES.O)
    val outputFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd, HH:mm:ss")

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDisplayDate(string: String, format: String? = null): String {
        if (format != null) {
            format?.let {
                val formatter = DateTimeFormatter.ofPattern(format, Locale.getDefault())
                val date = LocalDateTime.parse(string, dbFormatter)
                return formatter.format(date)
            }
        } else {
            val date = LocalDateTime.parse(string, dbFormatter)
            return outputFormatter.format(date)
        }
        return  ""
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun daysAwayString(dateString: String): String {
        val date = LocalDateTime.parse(dateString, dbFormatter)
        val currDate = LocalDateTime.now()
        val minutes = ChronoUnit.MINUTES.between(date, currDate)
        val hours = ChronoUnit.HOURS.between(date, currDate)
        val weeks = ChronoUnit.WEEKS.between(date, currDate)
        val days = ChronoUnit.DAYS.between(date, currDate)
        val months = ChronoUnit.MONTHS.between(date, currDate)

        if (months > 0 ) {
            return if (months == 1.toLong()) {
                "$months month ago"
            } else {
                "$months months ago"
            }
        } else if (weeks > 0 ) {
            return if (weeks == 1.toLong()) {
                "$weeks week ago"
            } else {
                "$weeks weeks ago"
            }
        } else if (days > 0 ) {
            return if (days == 1.toLong()) {
                "$days day ago"
            } else {
                "$days days ago"
            }
        } else if (hours > 0 ) {
            return if (hours == 1.toLong()) {
                "$hours hour ago"
            } else {
                "$hours hours ago"
            }
        } else if (minutes > 0 ) {
            return if (minutes == 1.toLong()) {
                "$minutes minute ago"
            } else {
                "$minutes minutes ago"
            }
        }
        return "just now"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun numDaysAway(dateString: String): Long {
        val date = LocalDateTime.parse(dateString, dbFormatter)
        val currDate = LocalDateTime.now()
        return ChronoUnit.DAYS.between(date, currDate)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun daysInFuture(dateString: String): String {
        val date = LocalDateTime.parse(dateString, dbFormatter)
        val currDate = LocalDateTime.now()
        val minutes = ChronoUnit.MINUTES.between(currDate, date)
        val hours = ChronoUnit.HOURS.between(currDate, date)
        val weeks = ChronoUnit.WEEKS.between(currDate, date)
        val days = ChronoUnit.DAYS.between(currDate, date)
        val months = ChronoUnit.MONTHS.between(currDate, date)

        if (months > 0 ) {
            return if (months == 1.toLong()) {
                "$months month"
            } else {
                "$months months"
            }
        } else if (weeks > 0 ) {
            return if (weeks == 1.toLong()) {
                "$weeks week"
            } else {
                "$weeks weeks"
            }
        } else if (days > 0 ) {
            return if (days == 1.toLong()) {
                "$days day"
            } else {
                "$days days"
            }
        } else if (hours > 0 ) {
            return if (hours == 1.toLong()) {
                "$hours hour"
            } else {
                "$hours hours"
            }
        } else if (minutes > 0 ) {
            return if (minutes == 1.toLong()) {
                "$minutes minute"
            } else {
                "$minutes minutes"
            }
        }

        return "Event has passed"
    }
}