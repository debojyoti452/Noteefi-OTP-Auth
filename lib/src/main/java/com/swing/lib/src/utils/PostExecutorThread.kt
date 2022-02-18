package com.swing.lib.src.utils

import kotlinx.coroutines.CoroutineDispatcher

internal interface PostExecutorThread {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}

