package com.swing.lib.src.component

import android.content.Context
import com.swing.lib.src.remote.api.NetworkModule
import com.swing.lib.src.remote.impl.NoteefiApiImpl
import com.swing.lib.src.remote.model.NoteefiRequestModel
import com.swing.lib.src.remote.model.NoteefiResponseModel
import com.swing.lib.src.utils.SuspendUseCase

internal class AuthOtpUseCase constructor(
    private val context: Context
) : SuspendUseCase<NoteefiRequestModel, NoteefiResponseModel>() {
    override suspend fun execute(params: NoteefiRequestModel?): NoteefiResponseModel {
        requireNotNull(params)
        return NoteefiApiImpl(
            service = NetworkModule(), context = context
        ).authOtp(params)
    }
}
