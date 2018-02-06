package com.maslick.threader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usingNothing()
        usingHandler()
        usingDeviceExecutor()
    }

    private fun usingDeviceExecutor() {
        val device = DeviceExecutor(callback)
        device.connect()
        device.disconnect()
    }

    private fun usingHandler() {
        val device = DeviceHandler(callback)
        device.connect()
        device.disconnect()
    }

    private fun usingNothing() {
        val device = DeviceSameThread(callback)
        device.connect()
        device.disconnect()
    }

    private val callback = object : LifecycleCallback {
        override fun onConnected(device: String) {
            Log.d("CALLBACK", "Successfully connected: $device, thread: ${Thread.currentThread().name}")
        }

        override fun onDisconnected() {
            Log.d("CALLBACK", "Disconnected, thread: ${Thread.currentThread().name}")
        }
    }
}
