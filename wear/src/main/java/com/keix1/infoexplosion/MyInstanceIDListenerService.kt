package com.keix1.infoexplosion


import android.util.Log

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyInstanceIDListenerService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        //ここで取得したInstanceIDをサーバー管理者に伝える

        val refreshedToken = FirebaseInstanceId.getInstance().token
//        Log.d(TAG, "Refreshed token: " + refreshedToken!!)
    }

    companion object {

        private val TAG = MyInstanceIDListenerService::class.java.simpleName
    }
}