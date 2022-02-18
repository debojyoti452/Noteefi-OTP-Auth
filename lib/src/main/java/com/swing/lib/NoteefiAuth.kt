package com.swing.lib

import android.content.Context
import com.swing.lib.src.component.AuthOtpUseCase
import com.swing.lib.src.component.NoteefiOnResponse
import com.swing.lib.src.component.SendOtpUseCase
import com.swing.lib.src.remote.model.NoteefiRequestModel
import com.swing.lib.src.utils.NoteefiResponse
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.runBlocking
import org.jetbrains.annotations.NotNull
import java.util.*

/**
 * Builder Class
 */
class NoteefiAuth constructor() {

    private lateinit var apiKey: String
    private lateinit var appContext: Context
    private lateinit var responseCallback: NoteefiOnResponse

    internal constructor(
        apiKey: String,
        appContext: Context,
        responseCallback: NoteefiOnResponse
    ) : this() {
        this.apiKey = apiKey
        this.appContext = appContext
        this.responseCallback = responseCallback
    }


    open class Builder {
        private lateinit var apiKey: String
        private lateinit var context: Context
        private lateinit var noteefiOnResponse: NoteefiOnResponse

        fun setApiKey(@NotNull apiKey: String): Builder {
            this.apiKey = apiKey
            return this
        }

        fun setContext(@NotNull context: Context): Builder {
            this.context = context
            return this
        }

        fun setResponseCallBack(@NotNull noteefiOnResponse: NoteefiOnResponse): Builder {
            this.noteefiOnResponse = noteefiOnResponse

            return this
        }

        fun create(): NoteefiAuth {
            return NoteefiAuth(
                apiKey, context, noteefiOnResponse
            )
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        responseCallback.onFailed(NoteefiResponse.Error(throwable.message).exception.toString())
    }

    fun authOtp(@NotNull otp: String) {
        runBlocking(exceptionHandler) {
            val res = AuthOtpUseCase(
                appContext
            ).invoke(
                NoteefiRequestModel(
                    apiKey = apiKey,
                    otp = otp,
                    deviceId = UUID.randomUUID().toString()
                )
            )

            res.let {
                NoteefiResponse.Success(it).data.message?.let { response ->
                    responseCallback.onSuccess(
                        response
                    )
                }
            }
        }
    }

    fun sentOtp(@NotNull email: String) {
        runBlocking(exceptionHandler) {
            val res = SendOtpUseCase(
                appContext
            ).invoke(
                NoteefiRequestModel(
                    apiKey = apiKey,
                    email = email,
                    deviceId = UUID.randomUUID().toString()
                )
            )

            res.let {
                NoteefiResponse.Success(it).data.message?.let { response ->
                    responseCallback.onSuccess(
                        response
                    )
                }
            }
        }
    }
}
