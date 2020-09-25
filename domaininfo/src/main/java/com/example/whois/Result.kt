package com.example.whois

/**
 * ****************************************************************************
 * Created by : arhan on 25 Sep, 2020 at 12:24.
 * Email : ashik.pstu.cse@gmail.com
 *
 * This class is for:
 * 1. providing result data for any kind of request
 * 2.
 * 3.
 *
 * Last edited by : arhan on 2020/09/25 at 12:24.
 *
 * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 * ****************************************************************************
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}