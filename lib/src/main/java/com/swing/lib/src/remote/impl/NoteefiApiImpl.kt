package com.swing.lib.src.remote.impl

import android.content.Context
import com.swing.lib.src.remote.api.NetworkModule
import com.swing.lib.src.remote.model.NoteefiRequestModel
import com.swing.lib.src.remote.model.NoteefiResponseModel
import com.swing.lib.src.remote.repository.NoteefiRepository
import com.swing.lib.src.utils.NoteefiRemoteErrorExtractor

internal class NoteefiApiImpl constructor(
    private val service: NetworkModule,
    private val context: Context
) : NoteefiRepository {
    override suspend fun sendOtp(data: NoteefiRequestModel): NoteefiResponseModel {
        val result = kotlin.runCatching { service.apiService(context).mockSendOtp(data = data) }

        if (result.isFailure) {
            val res = result.exceptionOrNull()
            return NoteefiResponseModel(success = false,
                message = res?.let { NoteefiRemoteErrorExtractor.extractErrorMessage(it) })
        }

        return result.getOrNull() ?: NoteefiResponseModel()
    }

    override suspend fun authOtp(data: NoteefiRequestModel): NoteefiResponseModel {
        val result = kotlin.runCatching { service.apiService(context).mockAuthOtp(data = data) }

        if (result.isFailure) {
            val res = result.exceptionOrNull()
            return NoteefiResponseModel(success = false,
                message = res?.let { NoteefiRemoteErrorExtractor.extractErrorMessage(it) })
        }

        return result.getOrNull() ?: NoteefiResponseModel()
    }
}
