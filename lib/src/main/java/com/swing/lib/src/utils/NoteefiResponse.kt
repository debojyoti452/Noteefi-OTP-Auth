package com.swing.lib.src.utils

internal sealed class NoteefiResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : NoteefiResponse<T>()
    object Loading : NoteefiResponse<Nothing>()
    data class Error(val exception: String?) : NoteefiResponse<Nothing>()
}
