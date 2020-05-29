package com.example.makefriendandroid.service

import android.util.Base64

class AppData {
    companion object {
        var username: String? = null
        var password: String? = null

        fun getAuthorization(): String {
            if (username == null || password == null) {
                return ""
            }
            val str = username + ":" + password
            val base64 = Base64.encodeToString(str.toByteArray(), Base64.NO_WRAP)
            return "Basic " + base64
        }
    }
}