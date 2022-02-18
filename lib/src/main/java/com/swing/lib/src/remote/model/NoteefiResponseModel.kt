package com.swing.lib.src.remote.model

import com.google.gson.annotations.SerializedName

data class NoteefiResponseModel(
    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,
)
