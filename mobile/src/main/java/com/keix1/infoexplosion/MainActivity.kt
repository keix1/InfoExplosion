package com.keix1.infoexplosion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val CurrentToken = FirebaseInstanceId.getInstance().token
        Log.d("inininmain", CurrentToken);
    }
}
