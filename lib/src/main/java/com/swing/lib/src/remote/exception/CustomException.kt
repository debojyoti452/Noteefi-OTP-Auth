package com.swing.lib.src.remote.exception

internal class CustomException(override val message: String, val throwable: Throwable? = null) : Exception(message)
