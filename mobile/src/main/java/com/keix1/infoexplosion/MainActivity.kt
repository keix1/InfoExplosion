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
import android.net.Uri
import android.support.v4.app.TaskStackBuilder


class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CurrentToken = FirebaseInstanceId.getInstance().token

        //Push通知の購読開始
        FirebaseMessaging.getInstance().subscribeToTopic("mytopic")

        var extras = intent.extras
        if(extras != null) {
            var value = extras.getString("data")
            if(value != null) {
                var uri = Uri.parse(value)
                var i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
        }


    }
}
