package com.swing.lib.src.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal abstract class SuspendUseCase<in Params, out T> {

    suspend operator fun invoke(params: Params? = null): T {
        return withContext(Dispatchers.IO) {
            execute(params)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: Params?): T
}

