package com.keix1.infoexplosion

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.widget.Button
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import android.os.Build
import android.app.PendingIntent
import android.content.Intent
import android.app.NotificationChannel
import android.graphics.Color
import android.support.v4.app.TaskStackBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val CurrentToken = FirebaseInstanceId.getInstance().token
        Log.d("inininmain", CurrentToken)

        //Push通知の購読開始
        FirebaseMessaging.getInstance().subscribeToTopic("mytopic")

        var button : Button = findViewById(R.id.button) as Button
        button.setOnClickListener { view ->


        }


    }
}
