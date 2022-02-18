package com.swing.noteefi_auth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.swing.lib.NoteefiAuth
import com.swing.lib.src.component.NoteefiOnResponse

class MainActivity : AppCompatActivity(), NoteefiOnResponse {

    private val noteefiAuth by lazy {
        NoteefiAuth.Builder()
            .setApiKey(BuildConfig.API_KEY)
            .setContext(applicationContext)
            .setResponseCallBack(this)
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.authOtp)
            .setOnClickListener {
                noteefiAuth.authOtp("123456")
            }

        findViewById<Button>(R.id.requestOtp)
            .setOnClickListener {
                noteefiAuth.sentOtp("deb@gmail.com")
            }
    }

    override fun onSuccess(message: String) {
        Log.d("MainActivityCall", message)
    }

    override fun onFailed(message: String) {
        Log.d("MainActivityCall", message)
    }
}
