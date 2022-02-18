package com.swing.lib.src.remote.service

import com.swing.lib.src.remote.model.NoteefiRequestModel
import com.swing.lib.src.remote.model.NoteefiResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

internal interface NoteefiApiService {
    @POST("v1/mockSendOtp")
    suspend fun mockSendOtp(@Body data: NoteefiRequestModel): NoteefiResponseModel

    @POST("v1/mockAuthOtp")
    suspend fun mockAuthOtp(@Body data: NoteefiRequestModel): NoteefiResponseModel
}
