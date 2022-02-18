package com.swing.lib.src.remote.model

import com.google.gson.annotations.SerializedName

internal data class NoteefiRequestModel(

    @field:SerializedName("api_key")
    val apiKey: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("otp")
    val otp: String? = null,

    @field:SerializedName("device_id")
    val deviceId: String? = null
)
