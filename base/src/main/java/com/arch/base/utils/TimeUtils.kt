package com.arch.base.utils

import androidx.annotation.NonNull
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import javax.inject.Inject

class TimeUtils @Inject internal constructor() {

    /**
     * Formats the passed date string following the passed format pattern.
     *
     * @param dateString    the string of the date to format
     * @param formatPattern the pattern to format date string
     */
    @NonNull
    fun formatDateString(@NonNull dateString: String, @NonNull formatPattern: String): String {
        val sdf = SimpleDateFormat(formatPattern, Locale.ENGLISH)
        val date = parseStringToDateWithPassedPattern(dateString, "yyyy-MM-dd")
        return sdf.format(date)
    }

    @NonNull
    fun formatLongToDate(@NonNull long: Long) : String {
        val sdf = SimpleDateFormat("yyyy-MMM-dd", Locale.getDefault())
        try {
            return sdf.format(Date(long)).toString()
        } catch (e: ParseException) {
            throw RuntimeException("Error formatting $long value to date")
        }
    }

    /**
     * Parses the passed string to a date with the passed format.
     *
     * @param dateString    the string of the date to parse
     * @param formatPattern the pattern to format date string
     * @throws RuntimeException if there is any problems while parsing
     */
    @NonNull
    fun parseStringToDateWithPassedPattern(@NonNull dateString: String, @NonNull formatPattern: String): Date {
        val sdf = SimpleDateFormat(formatPattern, Locale.getDefault())
        try {
            return sdf.parse(dateString)
        } catch (e: ParseException) {
            throw RuntimeException("Error formatting $dateString with pattern $formatPattern to Date")
        }

    }
}
