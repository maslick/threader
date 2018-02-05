package com.maslick.threader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usingDeviceExecutor()
    }

    fun usingDeviceExecutor() {
        val device = DeviceExecutor(callback)
        println("Calling thread: ${Thread.currentThread().name}")
        println("Connecting")
        device.connect()
        device.disconnect()
    }

    val callback = object : LifecycleCallback {
        override fun onConnected(device: String) {
            println("Successfully connected: ${device}, thread: ${Thread.currentThread().name}")
        }

        override fun onDisconnected() {
            println("Disconnected, thread: ${Thread.currentThread().name}")
        }

    }
}
