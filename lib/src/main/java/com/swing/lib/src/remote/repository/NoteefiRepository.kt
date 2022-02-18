package com.swing.lib.src.remote.repository

import com.swing.lib.src.remote.model.NoteefiRequestModel
import com.swing.lib.src.remote.model.NoteefiResponseModel

internal interface NoteefiRepository {
    suspend fun sendOtp(data: NoteefiRequestModel): NoteefiResponseModel
    suspend fun authOtp(data: NoteefiRequestModel): NoteefiResponseModel
}
