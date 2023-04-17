package com.example.classhangman.email

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryReceiver: BroadcastReceiver() {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Low battery from Manifest receiver", Toast.LENGTH_SHORT).show()
        println("Low battery from Manifest receiver")
    }
}