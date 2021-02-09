package com.vamosys.drs.view.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object Utils {
    fun epochToDateTime(time: Long): String{
        val formatter = SimpleDateFormat("MMM d hh:mm aaa")
        return formatter.format(time)
    }

    fun getHoursDiff(tripStartedTime: Long?): String {
        var currentEpoch = Date().time
        var diffInMillisec: Long = currentEpoch - tripStartedTime!!


        val days: Long = TimeUnit.MILLISECONDS.toDays(diffInMillisec)
        val hours: Long = TimeUnit.MILLISECONDS.toHours(diffInMillisec)
        val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(diffInMillisec)
        val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec)

        if (days>0)
            return "$days Days"
        else if (hours>0)
            return "$hours Hours"
        else if (minutes>0)
            return "$minutes Minutes"
        else
            return "$seconds Seconds"

    }
}