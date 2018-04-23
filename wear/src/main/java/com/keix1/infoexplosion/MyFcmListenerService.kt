package com.keix1.infoexplosion


import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.net.Uri
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import android.util.Log

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFcmListenerService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage?) {
        val from = message!!.from
        val data = message.data

        Log.d(TAG, "from:" + from!!)
        Log.d(TAG, "data:" + data.toString())

        val msg = data["data"].toString()
        sendNotification(data)
    }

    private fun sendNotification(message: Map<String, String>) {
            var longArray = LongArray(4)
            longArray[0] = 0L
            longArray[1] = 300L
            longArray[2] = 100L
            longArray[3] = 100L
                    // 通知を作成
            val builder = NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_cc_checkmark)
                    .setContentTitle(message["title"])
                    .setContentText(message["body"])
                    .setVibrate(longArray)
                    .setDefaults(Notification.DEFAULT_VIBRATE)

            // Activity を起動
            val resultIntent = Intent(this, MainActivity::class.java)
            val stackBuilder = TaskStackBuilder.create(this)
            stackBuilder.addParentStack(MainActivity::class.java)
            stackBuilder.addNextIntent(resultIntent)
            val pendingIntent = stackBuilder.getPendingIntent(
                    0,
                    PendingIntent.FLAG_UPDATE_CURRENT
            )
            builder.setContentIntent(pendingIntent)

            val notificationId = 1

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.notify(notificationId, builder.build())

    }

//    private fun sendNotification(message: Map<String, String>) {
//
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
//                PendingIntent.FLAG_ONE_SHOT)
//
//        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
//        val notificationBuilder = NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle(message["title"])
//                .setSubText(message["body"])
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri)
//                .setStyle(NotificationCompat.BigTextStyle().bigText(message["data"]))
//                .setContentIntent(pendingIntent)
//                .setDefaults(Notification.DEFAULT_ALL)
//
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        notificationManager.notify(0, notificationBuilder.build())
//    }

    companion object {

        private val TAG = MyFcmListenerService::class.java.simpleName
    }
}